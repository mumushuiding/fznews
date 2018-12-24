package com.lt.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.Incomeadjust;
import com.lt.cloud.pojo.IncomeajustReceiver;
import com.lt.cloud.service.IncomeAdjustService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("/incomeAdjust")
public class IncomeadjustController {
	
	@Autowired
	private IncomeAdjustService incomeAdjustService;
	
	@RequestMapping(value="/findAll")
	public Mono<String> findAll(@RequestBody String json){
		IncomeajustReceiver receiver=JsonUtils.getGson().fromJson(json, IncomeajustReceiver.class);
		Page<Incomeadjust> page=this.incomeAdjustService.findAll(receiver);
		return Mono.just(JsonUtils.formatPageForPagination(page));
		
	}
}
