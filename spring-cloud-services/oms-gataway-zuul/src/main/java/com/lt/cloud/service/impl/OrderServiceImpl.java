package com.lt.cloud.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codingapi.tx.annotation.TxTransaction;
import com.lt.cloud.feign.OrderFeignClient;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.pojo.adv.Advorder;
import com.lt.cloud.pojo.adv.AdvorderReceiver;
import com.lt.cloud.service.AdvService;
import com.lt.cloud.service.OrderService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;
@Component
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderFeignClient orderFeignClient;
	@Autowired
	private AdvService advService;
	@Override
	public Mono<String> findAll(String receiver) {
		System.out.println(receiver);
		return Mono.just(this.orderFeignClient.findAll(receiver));
	}

	@Override
	public Advorder findById(Long id) {
		
		return JsonUtils.getGson().fromJson(this.orderFeignClient.findById(id), Advorder.class);
	}

	@Override
	public Boolean save(String advorder) {
		
		return this.orderFeignClient.save(advorder);
	}

	@Override
	@TxTransaction
	public Boolean updateAllWithAdvitem(String advitems) {
		
		return this.orderFeignClient.updateAllWithAdvitem(advitems);
	}

	@Override
	@TxTransaction
	public Boolean deleteAdvitem(Advitem advitem) {
		advitem.setAI_AmountReceivable(-advitem.getAI_AmountReceivable());
		advitem.setAI_AmountReceived(-advitem.getAI_AmountReceived());
		advitem.setAI_BalancedMoney(-(advitem.getAI_BalancedMoney()==null?0.0:advitem.getAI_BalancedMoney()));
		List<Advitem> advitems=new ArrayList<>();
		advitems.add(advitem);
		return this.orderFeignClient.updateAllWithAdvitem(JsonUtils.getGson().toJson(advitems));
	}

	@Override
	@TxTransaction
	public Boolean deleteById(Long id) {
		return this.orderFeignClient.deleteById(id);
	}

	@Override
	@TxTransaction(isStart=true)
	public boolean deleteOrderById(Long id) {
		Boolean orderres=this.deleteById(id);
		Boolean advres=this.advService.deleteByOrderId(id);
		return orderres&&advres;
	}
	
	
}
