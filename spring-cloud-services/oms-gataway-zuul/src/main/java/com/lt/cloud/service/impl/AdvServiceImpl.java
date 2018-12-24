package com.lt.cloud.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.tx.annotation.TxTransaction;
import com.lt.cloud.feign.AdvFeignClient;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.pojo.adv.AdvitemReceiver;
import com.lt.cloud.pojo.adv.AdvotherReceiver;
import com.lt.cloud.service.AdvService;
import com.lt.cloud.service.OrderService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;
@Component
public class AdvServiceImpl implements AdvService{
	@Autowired
	private AdvFeignClient advFeignClient;
	@Autowired
	private OrderService orderService;

	@Override
	public String selectAllAdvitem(Integer pageIndex, Integer pageSize, HashMap<String, Object> params) {
		
		return this.advFeignClient.selectAllAdvitem(pageIndex, pageSize, params);
	}

	@Override
	public Advitem insertAdvitem(Advitem advitem) {
		
		return this.advFeignClient.insertAdvitem(advitem);
	}

	@Override
	public String selectAllAdvother(AdvotherReceiver receiver) {
		
		return this.advFeignClient.selectAllAdvOther(receiver);
	}

	@Override
	public String selectById(Long id) {
		
		return this.advFeignClient.selectById(id);
	}

	@Override
	public Advitem selectAdvItemById(Long id) {
		
		return JsonUtils.getGson().fromJson(this.advFeignClient.selectById(id), Advitem.class);
	}

	@Override
	public Long updateAdvitem(Advitem advitem) {
		
		return this.advFeignClient.updateAdvitem(advitem);
	}

	@Override
	@TxTransaction
	public Boolean deleteAdvitem(Long id) {
	
		return this.advFeignClient.deleteAdvitem(id);
	}

	@Override
	public Mono<String> findAll(String receiver) {
		
		return Mono.just(this.advFeignClient.findAll(receiver));
	}

	@Override
	public String selectAllPricelistitem(AdvotherReceiver receiver) {
		return this.advFeignClient.selectAllPricelistitem(receiver);
	}

	@Override
	@TxTransaction
	public Boolean saveAll(String advitems) {
		
		return this.advFeignClient.saveAll(advitems);
	}

	@Override
	public String findById(Long id) {
		
		return  this.advFeignClient.findById(id);
	}

	@Override
	@TxTransaction
	public Boolean updateAll(String advitems) {
		
		return this.advFeignClient.updateAll(advitems);
	}

	@Override
	@TxTransaction
	public Boolean deleteByOrderId(Long id) {
		
		return this.advFeignClient.deleteByOrderId(id);
	}

	@Override
    @TxTransaction(isStart = true)
	public Boolean save(String advitems) {
		boolean res=this.saveAll(advitems) && this.orderService.updateAllWithAdvitem(advitems);
//		int a=100/0;
		return res;
	}

	@Override
	@TxTransaction(isStart = true)
	public Boolean deleteById(Long id) {
		Advitem advitem=JsonUtils.getGson().fromJson(this.findById(id), Advitem.class);
		boolean advres=this.deleteAdvitem(id);
		boolean orderres=this.orderService.deleteAdvitem(advitem);
		return advres && orderres;
	}

	


}
