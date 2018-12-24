package com.lt.cloud.feign;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;
@FeignClient(name="oms-provider-payment")
public interface PaymentFeignClient {
	@RequestMapping("/payment/findAll")
	public String selectAllPayment(@RequestParam HashMap<String, Object> params);
	@RequestMapping("/payment/findAll")
	public String findAll(@RequestBody String receive);
	@RequestMapping("/payment/findAllCollectionMode")
	public String findAllCollectionMode();
	@RequestMapping("/payment/save")
	public Boolean save(@RequestBody String payment);
	@RequestMapping("/payment/update")
	public Boolean update(@RequestBody String payment);
	@RequestMapping("/payment/updateInvoice")
	public Boolean updateInvoice(@RequestBody String payment);
	@RequestMapping("/payment/findById/{Id}")
	public String findById(@PathVariable Long Id);
	@RequestMapping("/payment/deleteInvoice")
	public Boolean deleteInvoice(@RequestBody String payment);
	@RequestMapping("/payment/deleteById/{id}")
	public void deleteById(@PathVariable Long id);
}
