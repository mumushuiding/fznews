package com.lt.cloud.service;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.User;

public interface IdentityService {
	User login(String loginname,String password);
	User login(User user);
	public List<User> selectAllUserWithHash(HashMap<String, Object> params);
	public User selectSingleUser(HashMap<String, Object> params);
	public Long updatePassword(Long userid,String password) ;
}
