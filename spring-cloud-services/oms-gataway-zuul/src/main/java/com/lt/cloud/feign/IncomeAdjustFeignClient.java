package com.lt.cloud.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lt.cloud.pojo.IncomeajustReceiver;
@FeignClient(name="oms-provider-incomeAdjust")
public interface IncomeAdjustFeignClient {
	@RequestMapping("/incomeAdjust/findAll")
	public String findAll(@RequestBody String receiver);
}
