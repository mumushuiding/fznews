package com.lt.cloud.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.lt.cloud.pojo.User;
import com.lt.cloud.pojo.UserReceiver;

public interface UserService {
	public String find4AutoComplete(String receiver);
	public User findByIdAsUser(@PathVariable Long id);
	public String findById(@PathVariable Long id);
}
