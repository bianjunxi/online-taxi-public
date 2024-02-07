package com.mi.apiboss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ClassName:  ServiceApiBossApplication
 * Description: api-boss主启动
 *
 * @author Jay
 * @version v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceApiBossApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApiBossApplication.class,args);
    }
}
