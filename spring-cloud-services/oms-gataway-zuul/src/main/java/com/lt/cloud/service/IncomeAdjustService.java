package com.lt.cloud.service;


import com.lt.cloud.pojo.IncomeajustReceiver;

import reactor.core.publisher.Mono;

public interface IncomeAdjustService {
	public Mono<String> findAll(String receiver);
}
