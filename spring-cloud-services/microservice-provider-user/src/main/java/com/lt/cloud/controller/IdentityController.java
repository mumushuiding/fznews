package com.lt.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.User;
import com.lt.cloud.service.IdentityService;

@RestController
public class IdentityController{
	@Autowired 
	private IdentityService identityService;

	@RequestMapping("/login")
	public User login(User user) {
		User login=identityService.login(user.getUSERCODE(), user.getUSERPASSWORD());
		return login;
	}
	@PostMapping("/updatePassword")
	public Long updatePassword(@RequestBody User user) {
		return identityService.updatePassword(user.getNUSERID(), user.getUSERPASSWORD());
	}
	

}
