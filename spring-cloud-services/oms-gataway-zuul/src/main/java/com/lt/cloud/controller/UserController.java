package com.lt.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.UserReceiver;
import com.lt.cloud.service.UserService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;



@RefreshScope
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/find4AutoComplete")
	public Mono<String> find4AutoComplete(@RequestBody String receiver) {
		
		return Mono.just(this.userService.find4AutoComplete(receiver));
	}
	@RequestMapping("/user/findById/{id}")
	public String findById(@PathVariable Long id){
		return this.userService.findById(id);
	}
}
