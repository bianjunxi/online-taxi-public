package com.mi.apiboss.service.impl;

import com.mi.apiboss.remote.ServiceDriverUserClient;
import com.mi.apiboss.remote.ServiceMapClient;
import com.mi.apiboss.service.PointService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.request.ApiDriverPointRequest;
import com.mi.common.request.PointRequest;
import com.mi.common.vo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:  PointServiceImpl
 * Description: 司机上传位置
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class PointServiceImpl implements PointService {

    @Autowired
    private ServiceDriverUserClient serviceDriverUserClient;

    @Autowired
    private ServiceMapClient serviceMapClient;

    /**
     * 司机位置上传
     *
     * @param apiDriverPointRequest
     * @return
     */
    @Override
    public ResponseResult upload(ApiDriverPointRequest apiDriverPointRequest) {
        // 获取carId
        Long carId = apiDriverPointRequest.getCarId();

        // 通过carId 获取 tid、trid，调用 service-driver-user的接口
        ResponseResult<Car> carById = serviceDriverUserClient.getCarById(carId);
        Car car = carById.getData();
        String tid = car.getTid();
        String trid = car.getTrid();

        // 调用地图去上传
        PointRequest pointRequest = new PointRequest();
        pointRequest.setTid(tid);
        pointRequest.setTrid(trid);
        pointRequest.setPoints(apiDriverPointRequest.getPoints());

        return serviceMapClient.upload(pointRequest);
    }
}
