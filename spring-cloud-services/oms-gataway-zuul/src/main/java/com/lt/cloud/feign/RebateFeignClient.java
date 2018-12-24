package com.lt.cloud.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;
@FeignClient(name="oms-provider-rebate")
public interface RebateFeignClient {
	@RequestMapping("/rebate/findAll")
	public String findAll(@RequestBody RebateReceive rebateReceive);
	@RequestMapping("/rebate/save")
	public Boolean save(@RequestBody String rebate);
}
