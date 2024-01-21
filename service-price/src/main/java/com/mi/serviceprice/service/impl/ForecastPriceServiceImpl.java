package com.mi.serviceprice.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ForecastPriceDto;
import com.mi.common.response.DirectionResponse;
import com.mi.common.vo.PriceRule;
import com.mi.serviceprice.mapper.PriceRuleMapper;
import com.mi.serviceprice.remote.ServiceMapClient;
import com.mi.serviceprice.service.ForecastPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mi.common.response.ForecastPriceResponse;

import java.math.BigDecimal;

/**
 * ClassName:  ForecastPriceServiceImpl
 * Description: 预估价格
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class ForecastPriceServiceImpl implements ForecastPriceService {

    @Autowired
    private PriceRuleMapper priceRuleMapper;

    @Autowired
    private ServiceMapClient serviceMapClient;

    /**
     * 根据出发地和目的地经纬度 计算价格
     *
     * @param dto 请求参数封装经纬度
     * @return ResponseResult
     */
    @Override
    public ResponseResult forecastPrice(ForecastPriceDto dto) {

        String depLongitude = dto.getDepLongitude();
        String depLatitude = dto.getDepLatitude();
        String destLongitude = dto.getDestLongitude();
        String destLatitude = dto.getDestLatitude();

        log.info(depLongitude);
        log.info(depLatitude);
        log.info(destLongitude);
        log.info(destLatitude);

        log.info("调用地图服务,查询距离和时长");
        ResponseResult<DirectionResponse> driving = serviceMapClient.driving(dto);
        Integer distance = driving.getData().getDistance();
        Integer duration = driving.getData().getDuration();
        log.info("距离：" + distance + ",时长：" + duration);

        log.info("读取计价规则");
        PriceRule priceRule = priceRuleMapper.selectOne(Wrappers.<PriceRule>lambdaQuery().
                eq(PriceRule::getCityCode, "110000").eq(PriceRule::getVehicleCode, "1"));

        if (priceRule == null){
            ResponseResult.fail(CommonStatusEnum.PRICE_RULE_EMPTY.getCode(),CommonStatusEnum.PRICE_RULE_EMPTY.getMessage());
        }

        System.out.println(priceRule);


        log.info("根据距离、时长和计价规则预估价格");
        Double price = getPrice(distance, duration, priceRule);

        ForecastPriceResponse response = new ForecastPriceResponse();
        response.setPrice(price);

        return ResponseResult.success(response);
    }

    /**
     * 根据计价素材和计价规则预估价格
     * @param distance 距离
     * @param duration 时长
     * @param priceRule 规则
     * @return
     */
    private static Double getPrice(Integer distance,Integer duration,PriceRule priceRule){
        BigDecimal price = new BigDecimal(0);
        // 起步价
        Double startFare = priceRule.getStartFare();
        BigDecimal startFareDecimal = new BigDecimal(startFare);
        price = price.add(startFareDecimal);

        // 里程费
        // 总里程 m
        BigDecimal distanceDecimal = new BigDecimal(distance);
        // 总里程 km
        BigDecimal divideMileDecimal = distanceDecimal.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP);
        // 起步里程
        Integer startMile = priceRule.getStartMile();
        BigDecimal startMileDecimal = new BigDecimal(startMile);
        double distanceSubtract = divideMileDecimal.subtract(startMileDecimal).doubleValue();
        // 最终收费的里程数 km
        Double mile = distanceSubtract < 0 ? 0 : distanceSubtract;
        BigDecimal mileDecimal = new BigDecimal(mile);
        // 计程单价 元/km
        Double unitPricePerMile = priceRule.getUnitPricePerMile();
        BigDecimal unitPricePerMileDecimal = new BigDecimal(unitPricePerMile);
        // 里程价格
        BigDecimal mileFare = mileDecimal.multiply(unitPricePerMileDecimal).setScale(2, BigDecimal.ROUND_HALF_UP);
        price = price.add(mileFare);


        // 时长费
        BigDecimal time = new BigDecimal(duration);
        // 时长分钟数
        BigDecimal timeDicimal = time.divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP);
        // 计时单价
        Double unitPricePerMinute = priceRule.getUnitPricePerMinute();
        BigDecimal unitPricePerMinuteDicimal = new BigDecimal(unitPricePerMinute);
        // 时长费用
        BigDecimal timeFare = timeDicimal.multiply(unitPricePerMinuteDicimal);
        price = price.add(timeFare).setScale(2, BigDecimal.ROUND_HALF_UP);

        return price.doubleValue();
    }

}
