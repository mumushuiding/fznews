package com.lt.cloud.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lt.cloud.pojo.User;
import com.lt.cloud.service.IdentityService;
import com.lt.cloud.utils.JsonUtils;

@Controller
@SessionAttributes(names="sysuser")
@RefreshScope
@RequestMapping("/user")
public class IdentityController {
	@Autowired
	private IdentityService identityService;
	@RequestMapping("/loginAndReturn")
	@ResponseBody
	public User loginAndReturn(@RequestBody String user) {
		User receive=JsonUtils.getGson().fromJson(user, User.class);
		System.out.println(receive.getUSERCODE());
		HashMap<String, Object> params=new HashMap<>();
		params.put("USERCODE", receive.getUSERCODE());
		params.put("USERPASSWORD", receive.getUSERPASSWORD());
		User login=this.identityService.login(params);
		if(login!=null) return login;
		return null;
	}
	
	@PostMapping("/updatePassword")
	public String updatePassword(User user) throws UnsupportedEncodingException {
		if(this.identityService.updatePassword(user)==0l) {
			return "redirect:/error/op?msg="+URLEncoder.encode("密码修改失败", "utf-8");
		}
		return "redirect:/suc/op?msg="+URLEncoder.encode("密码修改成功", "utf-8");
	}
}
