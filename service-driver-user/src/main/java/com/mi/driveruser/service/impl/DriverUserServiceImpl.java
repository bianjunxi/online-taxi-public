package com.mi.driveruser.service.impl;

import com.mi.common.constant.CommonStatusEnum;
import com.mi.common.constant.DriverCarConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverUser;
import com.mi.common.vo.DriverUserWorkStatus;
import com.mi.driveruser.mapper.DriverUserMapper;
import com.mi.driveruser.mapper.DriverUserWorkStatusMapper;
import com.mi.driveruser.service.DriverUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:  DriverUserServiceImpl
 * Description: 司机信息管理service
 *
 * @author Jay
 * @version v1.0
 */
@Service
@Slf4j
public class DriverUserServiceImpl implements DriverUserService {

    @Autowired
    private DriverUserMapper driverUserMapper;

    @Autowired
    private DriverUserWorkStatusMapper driverUserWorkStatusMapper;

    /**
     * 插入司机信息
     *
     * @param driverUser 司机实体类
     * @return
     */
    @Override
    public ResponseResult addDriverUser(DriverUser driverUser) {
        driverUser.setGmtCreate(LocalDateTime.now());
        driverUser.setGmtModified(LocalDateTime.now());
        driverUserMapper.insert(driverUser);

        //初始化司机工作状态表
        DriverUserWorkStatus driverUserWorkStatus = new DriverUserWorkStatus();
        driverUserWorkStatus.setDriverId(driverUser.getId());
        driverUserWorkStatus.setWorkStatus(DriverCarConstants.DRIVER_WORK_STATUS_STOP);
        driverUserWorkStatus.setGmtCreate(LocalDateTime.now());
        driverUserWorkStatus.setGmtModified(LocalDateTime.now());
        driverUserWorkStatusMapper.insert(driverUserWorkStatus);

        return ResponseResult.success("");
    }

    /**
     * 修改司机信息
     *
     * @param driverUser 司机实体类
     * @return
     */
    @Override
    public ResponseResult updateDriverUser(DriverUser driverUser) {
        driverUser.setGmtModified(LocalDateTime.now());
        driverUserMapper.updateById(driverUser);
        return ResponseResult.success("");
    }

    /**
     * 根据手机号查询司机
     *
     * @param driverPhone
     * @return
     */
    @Override
    public String getDriverUserByPhone(String driverPhone) {
        Map<String,Object> map = new HashMap<>();
        map.put("driver_phone", driverPhone);
        map.put("state", DriverCarConstants.DRIVER_STATE_VALID);
        List<DriverUser> driverUsers = driverUserMapper.selectByMap(map);
        if (driverUsers.isEmpty()){
            throw new RuntimeException(CommonStatusEnum.DRIVER_NOT_EXITST.getMessage());
        }
        DriverUser driverUser = driverUsers.get(0);
        return driverUser.getDriverPhone();
    }
}
