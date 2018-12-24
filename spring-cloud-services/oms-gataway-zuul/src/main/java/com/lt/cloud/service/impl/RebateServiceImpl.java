package com.lt.cloud.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lt.cloud.feign.RebateFeignClient;
import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;
import com.lt.cloud.service.RebateService;
import reactor.core.publisher.Mono;
@Component
public class RebateServiceImpl implements RebateService{
	@Autowired
	private RebateFeignClient rebateFeignClient;

	@Override
	public Mono<String> findAll(RebateReceive receive) {
		
		return Mono.just(this.rebateFeignClient.findAll(receive));
	}

	@Override
	public Boolean save(String rebate) {
		return this.rebateFeignClient.save(rebate);
	}
	


}
