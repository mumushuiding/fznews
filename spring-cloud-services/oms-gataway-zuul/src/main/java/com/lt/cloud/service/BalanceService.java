package com.lt.cloud.service;
import com.lt.cloud.pojo.BalanceReceiver;
import reactor.core.publisher.Mono;
public interface BalanceService {
	public Mono<String> findAll(String receiver);

	public Boolean saveAll(String json);

	public boolean balance(String json);

	public Mono<String> findAllReversable(Long payId);
	
	public String findByPayIdResultAdv(Long payId);
}
