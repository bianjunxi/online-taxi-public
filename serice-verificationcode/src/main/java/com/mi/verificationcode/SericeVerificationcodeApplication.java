package com.mi.verificationcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SericeVerificationcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SericeVerificationcodeApplication.class, args);
	}

}
