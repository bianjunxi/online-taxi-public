package com.mi.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: ServicePassengerUserApplication
 * Description:
 *
 * @author Jay
 * @version v1.0
 */
@SpringBootApplication
@MapperScan("com.mi.user.mapper")
@EnableDiscoveryClient
public class ServicePassengerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePassengerUserApplication.class, args);
    }
}
