package com.lt.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.BalanceReceiver;
import com.lt.cloud.service.BalanceService;
import com.lt.cloud.utils.JsonUtils;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/balance")
public class BalanceController {
	@Autowired
	private BalanceService balanceService;
	
	@RequestMapping(value = "/findAll")
	public Mono<String> findAll(@RequestBody String json) {
		System.out.println("*******************"+json+"*********************");
		BalanceReceiver balanceReceiver=JsonUtils.getGson().fromJson(json, BalanceReceiver.class);
		Page<Balance> page=this.balanceService.findAll(balanceReceiver);
		return Mono.just(JsonUtils.formatPageForPagination(page));
	}
	@RequestMapping(value="/saveAll")
	public Mono<Boolean> saveAll(@RequestBody String json){
		try {
			return Mono.just(this.balanceService.saveAll(json));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	@RequestMapping(value="/findAllReversable/{payId}")
	public Mono<String> findAllReversable(@PathVariable Long payId){
		return Mono.just(JsonUtils.getGson().toJson(this.balanceService.findAllReversable(payId)));
	}
	@RequestMapping(value="/findAllReversable")
	public Mono<String> findAllReversable1(@RequestBody String json){
		BalanceReceiver receiver=JsonUtils.getGson().fromJson(json, BalanceReceiver.class);
		return Mono.just(JsonUtils.getGson().toJson(this.balanceService.findAllReversable(receiver)));
	}
	@RequestMapping(value="/findByPayIdResultAdv/{payId}")
	public Mono<String> findByPayIdResultAdv(@PathVariable Long payId){
		return Mono.just(JsonUtils.getGson().toJson(this.balanceService.findByPayIdResultAdv(payId)));
	}
}
