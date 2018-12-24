package com.lt.cloud.mapper;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.User;
import com.lt.cloud.pojo.UserReceiver;

public interface UserMapper {
	public User login(User user);
	public List<User> selectAllUserWithHash(HashMap<String, Object> params);
	List<User> find4AutoComplete(UserReceiver receiver);
	public List<User> selectAllUser(User user);
	public Long updatePassword(HashMap<String, Object> params);
	User findById(Long id);
	
}
