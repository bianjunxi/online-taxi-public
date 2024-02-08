package com.mi.apiboss.controller;

import com.mi.apiboss.service.DriverCarBindingRelationshipService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.DriverCarBindingRelationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:  DriverCarBindingRelationshipController
 * Description: 司机车辆绑定
 *
 * @author Jay
 * @version v1.0
 */
@RestController
public class DriverCarBindingRelationshipController {


    @Autowired
    private DriverCarBindingRelationshipService driverCarBindingRelationshipService;

    @PostMapping("/bind")
    public ResponseResult bind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return driverCarBindingRelationshipService.bind(driverCarBindingRelationship);
    }

    @PostMapping("/unbind")
    public ResponseResult ubBind(@RequestBody DriverCarBindingRelationship driverCarBindingRelationship){
        return driverCarBindingRelationshipService.unBind(driverCarBindingRelationship);
    }

}
