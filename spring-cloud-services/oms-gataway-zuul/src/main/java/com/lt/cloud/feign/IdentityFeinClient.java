package com.lt.cloud.feign;

import java.util.HashMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.lt.cloud.pojo.User;

@FeignClient(name="microservice-provider-user")
public interface IdentityFeinClient {
	@PostMapping("/login")
	public User login(@RequestParam HashMap<String, Object> params);
	@PostMapping("/updatePassword")
	public Long updatePassword(@RequestBody User user);
}
