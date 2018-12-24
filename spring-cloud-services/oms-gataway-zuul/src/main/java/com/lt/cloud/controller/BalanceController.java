package com.lt.cloud.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.reflect.TypeToken;
import com.lt.cloud.config.SettingsErrorCode;
import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.BalanceReceiver;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.service.AdvService;
import com.lt.cloud.service.BalanceService;
import com.lt.cloud.service.OrderService;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;
@RestController
@RefreshScope
public class BalanceController {
	@Autowired
	private BalanceService balanceService;
	@RequestMapping("/balance/findAll")
	public Mono<String> findAll(@RequestBody String receiver){
		
		return this.balanceService.findAll(receiver);
		
	}
	/**
	 * 
	 * @param json为List<Balance>
	 * @return
	 */
	@RequestMapping("/balance/saveAll")
	public String saveAll(@RequestBody String json){
		
		return this.balanceService.balance(json)==true?SettingsErrorCode.SERVER_SUCCESS:SettingsErrorCode.SERVER_ERROR;
	}
	@RequestMapping("/balance/findAllReversable/{payId}")
	public Mono<String> findAllReversable(@PathVariable Long payId) {
		System.out.println("**************"+payId+"*********");
		return this.balanceService.findAllReversable(payId);
	}
}
