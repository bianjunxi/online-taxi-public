package com.mi.driveruser.controller;

import com.mi.common.constant.DriverCarConstants;
import com.mi.common.dto.ResponseResult;
import com.mi.common.response.DriverUserExistsResponse;
import com.mi.common.vo.DriverUser;
import com.mi.driveruser.service.DriverUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:  DriverUserController
 * Description: 司机信息controller
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class DriverUserController {

    @Autowired
    private DriverUserService driverUserService;

    @PostMapping("/user")
    public ResponseResult addUser(@RequestBody DriverUser driverUser){
        return driverUserService.addDriverUser(driverUser);
    }

    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody DriverUser driverUser){
        return driverUserService.updateDriverUser(driverUser);
    }

    /**
     * 查询 司机
     * 如果需要按照司机的多个条件做查询，那么此处用 /user
     * @return
     */
    @GetMapping("/check-driver/{driverPhone}")
    public ResponseResult<DriverUserExistsResponse> getUser(@PathVariable("driverPhone") String driverPhone){

        String driverUserPhone = driverUserService.getDriverUserByPhone(driverPhone);
        DriverUserExistsResponse response = new DriverUserExistsResponse();

        int ifExists = DriverCarConstants.DRIVER_EXISTS;
        if (driverUserPhone == null){
            ifExists = DriverCarConstants.DRIVER_NOT_EXISTS;
            response.setDriverPhone(driverPhone);
            response.setIfExists(ifExists);
        }else {
            response.setDriverPhone(driverUserPhone);
            response.setIfExists(ifExists);
        }

        return ResponseResult.success(response);
    }

}
