package com.mi.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: PassengerApplication
 * Description:
 *
 * @author Leo
 * @version v1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PassengerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PassengerApplication.class, args);
    }
}
