package com.lt.cloud.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lt.cloud.feign.fallback.OrderFeignFallback;
import com.lt.cloud.pojo.adv.AdvorderReceiver;
@FeignClient(name = "oms-provider-order",fallback = OrderFeignFallback.class)
public interface OrderFeignClient {
	@RequestMapping("/order/findAll")
	public String findAll(@RequestBody String receiver);
	@PostMapping("/order/save")
	public Boolean save(@RequestBody String advorder);
	@PostMapping("/order/updateAllWithAdvitem")
	public Boolean updateAllWithAdvitem(@RequestBody String advitems);
	@RequestMapping("/order/findById/{id}")
	public String findById(@PathVariable Long id);
	@RequestMapping("/order/deleteById/{id}")
	public Boolean deleteById(@PathVariable Long id);
}
