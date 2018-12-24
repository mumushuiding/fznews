package com.lt.cloud.controller;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;
import com.lt.cloud.service.RebateService;
import com.lt.cloud.utils.JsonUtils;
import com.netflix.client.ClientException;

import reactor.core.publisher.Mono;
@RestController
@RefreshScope
@RequestMapping("/rebate")
public class RebateController {
	@Autowired
	private RebateService rebateService;

	@RequestMapping("/findAll")
	public Mono<String> findAll(@RequestBody RebateReceive receive){
		
		return this.rebateService.findAll(receive);
	}
	@RequestMapping("/save")
	public void save(@RequestBody String json) {
		
		this.rebateService.save(json);
	}
}
