package com.lt.cloud.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.mapper.UserMapper;
import com.lt.cloud.pojo.User;
import com.lt.cloud.pojo.UserReceiver;
import com.lt.cloud.service.UserService;

@Component
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> selectAllUser(User user) {
		
		return this.userMapper.selectAllUser(user);
	}
	@Override
	public List<User> selectAllUserWithHash(HashMap<String, Object> params) {
		
		return this.userMapper.selectAllUserWithHash(params);
	}
	@Override
	public User findById(Long id) {
		
		return this.userMapper.findById(id);
	}
	@Override
	public List<User> find4AutoComplete(UserReceiver receiver) {
		
		return this.userMapper.find4AutoComplete(receiver);
	}

}
