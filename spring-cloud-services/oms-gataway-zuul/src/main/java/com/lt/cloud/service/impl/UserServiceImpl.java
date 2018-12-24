package com.lt.cloud.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.feign.UserFeignClient;
import com.lt.cloud.pojo.User;
import com.lt.cloud.pojo.UserReceiver;
import com.lt.cloud.service.UserService;
import com.lt.cloud.utils.JsonUtils;

@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private UserFeignClient userFeignClient;


	@Override
	public User findByIdAsUser(Long id) {
		
		return JsonUtils.getGson().fromJson(this.findById(id), User.class);
	}

	@Override
	public String findById(Long id) {
		
		return this.userFeignClient.findById(id);
	}
	@Override
	public String find4AutoComplete(String receiver) {
		
		return this.userFeignClient.find4AutoComplete(receiver);
	}

	
}
