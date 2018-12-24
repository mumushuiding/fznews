package com.lt.cloud.service;


import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;

import reactor.core.publisher.Mono;

public interface RebateService {
	public Mono<String> findAll(RebateReceive receive);
	Boolean save(String rebate);
}
