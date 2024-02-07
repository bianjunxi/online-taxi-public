package com.mi.driveruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName:  ServiceDriverUserApplication
 * Description: 司机信息管理启动类
 *
 * @author Jay
 * @version v1.0
 */
@SpringBootApplication
@MapperScan("com.mi.driveruser.mapper")
@EnableDiscoveryClient
public class ServiceDriverUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDriverUserApplication.class,args);
    }
}