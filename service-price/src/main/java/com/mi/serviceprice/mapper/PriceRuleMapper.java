package com.mi.serviceprice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mi.common.vo.PriceRule;
import org.springframework.stereotype.Repository;

/**
 * ClassName:  PriceRuleMapper
 * Description: 读取计价规则mapper
 *
 * @author Jay
 * @version v1.0
 */
@Repository
public interface PriceRuleMapper extends BaseMapper<PriceRule> {
}
