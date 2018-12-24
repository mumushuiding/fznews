package com.lt.cloud.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.pojo.AdvitemReceiver;
import com.lt.cloud.service.AdvitemQueryService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("/advitem")
public class AdvitemQueryController {
	@Value("${profile}")//测试config
	private String profile;
	
	@GetMapping("/profile")
	public String test() {
		return this.profile;
	}
	@Autowired
	private AdvitemQueryService advitemQueryService;
	@RequestMapping("/findAll")
	public Mono<String> findAll(@RequestBody String json){
		//分页
		AdvitemReceiver receiver=JsonUtils.getGson().fromJson(json, AdvitemReceiver.class);
		System.out.println(JsonUtils.getGson().toJson(receiver));
		Integer pageIndex=receiver.getPageIndex()==null?1:receiver.getPageIndex();
		Integer pageSize=receiver.getPageSize()==null?10:receiver.getPageSize();
		PageHelper.startPage(pageIndex,pageSize);
		List<Advitem> list=this.advitemQueryService.findAll(receiver);
		return Mono.just(JsonUtils.formatListForPagination(list, pageIndex, pageSize));
	}
	@RequestMapping("/findById/{id}")
	public String selectById(@PathVariable Long id) {
		return JsonUtils.getGson().toJson(this.advitemQueryService.selectById(id));
	}
}
