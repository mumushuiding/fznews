package com.lt.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lt.cloud.pojo.UserReceiver;

@FeignClient(name="microservice-provider-user")
public interface UserFeignClient {
	
	@RequestMapping("/user/find4AutoComplete")
	public String find4AutoComplete(@RequestBody String receiver);
	@RequestMapping("/user/findById/{id}")
	public String findById(@PathVariable Long id);
}
