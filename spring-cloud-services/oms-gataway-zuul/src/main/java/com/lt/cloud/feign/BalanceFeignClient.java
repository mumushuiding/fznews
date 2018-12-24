package com.lt.cloud.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lt.cloud.pojo.BalanceReceiver;

import reactor.core.publisher.Mono;


@FeignClient(name="oms-provider-balance")
public interface BalanceFeignClient {
	@RequestMapping(value = "/balance/findAll")
	public String findAll(@RequestBody String receiver);
	@RequestMapping(value = "/balance/saveAll")
	public Boolean saveAll(@RequestBody String json);
	@RequestMapping("/balance/findAllReversable/{payId}")
	public String findAllReversable(@PathVariable Long payId);
	@RequestMapping(value="/balance/findByPayIdResultAdv/{payId}")
	public String findByPayIdResultAdv(@PathVariable Long payId);
}
