package com.lt.cloud.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RefreshScope
@RequestMapping("/error")
public class ErrorController {
	
	@RequestMapping("/{form}")
	public String locate(@PathVariable String form,
			Model model,
			@RequestParam(required=false) String msg) throws UnsupportedEncodingException {
		if(msg!=null)model.addAttribute("msg", URLDecoder.decode(msg, "utf-8"));
		return "error/"+form;
	}
}
