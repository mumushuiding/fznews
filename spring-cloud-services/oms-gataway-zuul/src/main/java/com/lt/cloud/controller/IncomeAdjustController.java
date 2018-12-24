package com.lt.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.cloud.pojo.IncomeajustReceiver;
import com.lt.cloud.service.IncomeAdjustService;

import reactor.core.publisher.Mono;

@Controller
@RefreshScope
public class IncomeAdjustController {
	@Autowired
	private IncomeAdjustService incomeAdjustService;
	
	@RequestMapping("/incomeAdjust/{form}")
	public String locate(@PathVariable String form) {
		
		return "incomeAdjust/"+form;
	}
	
	@RequestMapping("/incomeAdjust/findAll")
	@ResponseBody
	public Mono<String> findAll(@RequestBody String receiver){
		
		
		return this.incomeAdjustService.findAll(receiver);
	}
	
}
