package com.lt.cloud.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.feign.IncomeAdjustFeignClient;
import com.lt.cloud.pojo.IncomeajustReceiver;
import com.lt.cloud.service.IncomeAdjustService;

import reactor.core.publisher.Mono;

@Component
public class IncomeAdjustServiceImpl implements IncomeAdjustService{
	@Autowired
	private IncomeAdjustFeignClient incomeAdjustFeignClient;

	@Override
	public Mono<String> findAll(String receiver) {
		
		return Mono.just(this.incomeAdjustFeignClient.findAll(receiver));
	}
	

}
