package com.lt.cloud.service;

import java.util.HashMap;

import com.lt.cloud.pojo.User;

public interface IdentityService {
	public User login(HashMap<String, Object> params);
	public Long updatePassword(User user);
}
