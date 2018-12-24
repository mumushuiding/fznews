package com.lt.cloud.service;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.User;
import com.lt.cloud.pojo.UserReceiver;

public interface UserService {
	List<User> selectAllUser(User user);
	public List<User> selectAllUserWithHash(HashMap<String, Object> params);
	List<User> find4AutoComplete(UserReceiver receiver);
	User findById(Long id);
}
