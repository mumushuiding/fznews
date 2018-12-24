package com.lt.cloud.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.feign.IdentityFeinClient;
import com.lt.cloud.pojo.User;
import com.lt.cloud.service.IdentityService;

@Component
public class IdentityServiceImpl implements IdentityService{
	@Autowired
	private IdentityFeinClient identityFeinClient;
	@Override
	public User login(HashMap<String, Object> params) {
		
		return this.identityFeinClient.login(params);
	}

	@Override
	public Long updatePassword(User user) {
		
		return this.identityFeinClient.updatePassword(user);
	}

}
