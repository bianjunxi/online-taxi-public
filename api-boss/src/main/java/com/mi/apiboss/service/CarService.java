package com.mi.apiboss.service;


import com.mi.apiboss.remote.DriverUserClient;
import com.mi.common.dto.ResponseResult;
import com.mi.common.vo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface CarService {

    ResponseResult addCar(Car car);
}
