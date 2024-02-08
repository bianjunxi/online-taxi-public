package com.mi.apiboss.service.impl;


import com.mi.apiboss.remote.DriverUserClient;
import com.mi.apiboss.service.CarService;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private DriverUserClient DriverUserClient;

    @Override
    public ResponseResult addCar(Car car){
        return DriverUserClient.addCar(car);
    }
}
