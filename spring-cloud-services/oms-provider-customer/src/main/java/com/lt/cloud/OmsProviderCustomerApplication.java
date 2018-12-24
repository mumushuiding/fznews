package com.lt.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.lt.cloud.mapper")
public class OmsProviderCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsProviderCustomerApplication.class, args);
	}
}
