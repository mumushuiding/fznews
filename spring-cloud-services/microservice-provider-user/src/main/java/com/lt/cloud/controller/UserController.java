package com.lt.cloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.lt.cloud.pojo.UserReceiver;
import com.lt.cloud.service.UserService;
import com.lt.cloud.utils.JsonUtils;

@RestController
@RefreshScope
public class UserController {

	
	@Autowired
	private UserService userService;
	

	@RequestMapping("/user/find4AutoComplete")
	public String find4AutoComplete(@RequestBody String json) {
		UserReceiver receiver=JsonUtils.getGson().fromJson(json, UserReceiver.class);
		receiver.setFields("NUSERID,USERNAME");
		PageHelper.startPage(1, receiver.getPageSize()==null?10:receiver.getPageSize());
		return JsonUtils.getGson().toJson(this.userService.find4AutoComplete(receiver));
	}
	@RequestMapping("/user/findById/{id}")
	public String findById(@PathVariable Long id) {
		return JsonUtils.getGson().toJson(this.userService.findById(id));
	}
}
