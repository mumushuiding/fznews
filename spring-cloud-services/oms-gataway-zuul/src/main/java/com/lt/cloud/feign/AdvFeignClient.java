package com.lt.cloud.feign;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.pojo.adv.AdvitemReceiver;
import com.lt.cloud.pojo.adv.AdvotherReceiver;


@FeignClient(name="oms-provider-adv")
public interface AdvFeignClient {
	
	@RequestMapping("/advitem/findAll")
	public String findAll(@RequestBody String receiver);
	
	@GetMapping("/advitem/selectAllAdvitem")
	public String selectAllAdvitem(@RequestParam Integer pageIndex,@RequestParam Integer pageSize,
			@RequestParam HashMap<String, Object> params);
	@RequestMapping("/advitem/insertAdvitem")
	public Advitem insertAdvitem(@RequestBody Advitem advitem);
	@RequestMapping("/advitem/saveAll")
	public Boolean saveAll(@RequestBody String advitem);
	@RequestMapping("/advitem/updateAll")
	public Boolean updateAll(@RequestBody String advitemList);
	@RequestMapping("/advother/selectAll")
	public String selectAllAdvOther(@RequestBody AdvotherReceiver receiver);
	
	@RequestMapping("/advitem/selectById/{id}")
	public String selectById(@PathVariable Long id);
	
	@RequestMapping("/advitem/updateAdvitem")
	public Long updateAdvitem(@RequestBody Advitem advitem);
	@RequestMapping("/advitem/deleteAdvitem/{id}")
	public Boolean deleteAdvitem(@PathVariable Long id);
	@RequestMapping("/pricelistitem/selectAll")
	public String selectAllPricelistitem(@RequestBody AdvotherReceiver receiver);
	@RequestMapping("/advitem/findById/{id}")
	public String findById(@PathVariable Long id);
	@RequestMapping("/advitem/deleteByOrderId/{id}")
	public Boolean deleteByOrderId(@PathVariable Long id);
	
}
