package com.lt.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lt.cloud.annotation.NoRepeatSubmit;
import com.lt.cloud.config.SettingsErrorCode;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.service.PaymentService;

import reactor.core.publisher.Mono;

@RestController
@RefreshScope
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@RequestMapping("/payment/findAll")
	public Mono<String> findAll(@RequestBody String receive){
		return Mono.just(this.paymentService.findAll(receive));
	}
	@RequestMapping("/payment/save")
	@NoRepeatSubmit
	public Mono<String> save(@RequestBody String json) {
		try {
			this.paymentService.save(json);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.just(SettingsErrorCode.SERVER_ERROR);
		}
		
	}
	/**
	 * 借票回款，涉及：新增收款、更新源借票收款、实平帐
	 * @param json
	 * @return
	 */
	@RequestMapping("/payment/moneyback")
	@NoRepeatSubmit
	public Mono<String> moneyback(@RequestBody String json){
		try {
			this.paymentService.moneyback(json);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.just(SettingsErrorCode.SERVER_ERROR);
		}
	}
	@RequestMapping("/payment/updateAndBalanceReal")
	@NoRepeatSubmit
	public Mono<String> updateAndBalanceReal(@RequestBody String json) {
		try {
			this.paymentService.updateAndBalanceReal(json);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			return Mono.just(SettingsErrorCode.SERVER_ERROR);
		}
		
	}
	@RequestMapping("/payment/findAllCollectionMode")
	public Mono<String> findAllCollectionMode() {
		
		return Mono.just(this.paymentService.findAllCollectionMode());
	}
	@RequestMapping("/payment/findById/{id}")
	public Mono<Payment> findById(@PathVariable Long id) {
		
		return Mono.just(this.paymentService.findById(id)).retry();
	}
	@RequestMapping("/payment/deleteBy/{id}")
	public Mono<String> deleteById(@PathVariable Long id){
		try {
			this.paymentService.deleteById(id);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
