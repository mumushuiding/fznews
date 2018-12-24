package com.lt.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.cloud.service.OmsPublicService;

@RefreshScope
@Controller
public class OmsPublicContreller {
	@Autowired
	private OmsPublicService omsPublicService;
	
	@RequestMapping("/advOrg/catTree")
	@ResponseBody
	public String getCatTree() {
		return this.omsPublicService.getCatTree();
	}
	@RequestMapping("/advTrade/catTree")
	@ResponseBody
	public String getAdvTradeTree() {
		return this.omsPublicService.getTradeTree();
	}
}
