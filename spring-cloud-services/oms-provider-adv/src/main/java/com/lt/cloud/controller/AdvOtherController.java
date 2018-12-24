package com.lt.cloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lt.cloud.pojo.AdvotherReceiver;
import com.lt.cloud.service.AdvOtherQueryService;
import com.lt.cloud.utils.JsonUtils;
@RefreshScope
@RestController
@RequestMapping("/advother")
public class AdvOtherController {
	@Autowired
	private AdvOtherQueryService advOtherQueryService;
	
	@RequestMapping("/selectAll")
	public String selectAll(@RequestBody AdvotherReceiver receiver) {
		System.out.println(JsonUtils.getGson().toJson(receiver));
		return JsonUtils.getGson().toJson(this.advOtherQueryService.selectAll(receiver));
	}

	
	
}
