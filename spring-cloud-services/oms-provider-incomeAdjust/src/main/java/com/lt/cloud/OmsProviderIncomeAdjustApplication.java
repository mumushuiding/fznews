package com.lt.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages="com.lt.cloud.dao.jpa")
public class OmsProviderIncomeAdjustApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmsProviderIncomeAdjustApplication.class, args);
	}
}
