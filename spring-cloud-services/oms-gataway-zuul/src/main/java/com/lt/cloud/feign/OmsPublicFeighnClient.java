package com.lt.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="oms-provider-public")
public interface OmsPublicFeighnClient {
	@RequestMapping("/advOrg/catTree")
	public String getCatTree();
	@RequestMapping("/advTrade/catTree")
	public String getAdvTradeTree();
}
