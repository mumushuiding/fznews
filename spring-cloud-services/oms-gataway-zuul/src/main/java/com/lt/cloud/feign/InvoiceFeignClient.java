package com.lt.cloud.feign;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;

import reactor.core.publisher.Mono;

@FeignClient(name="oms-provider-invoice")
public interface InvoiceFeignClient {
	@RequestMapping("/invoice/findAll")
	public String findAll(@RequestParam HashMap<String, Object> params);
	@RequestMapping("/invoice/findAll")
	public String findAll(@RequestBody String receiver);
	@RequestMapping("/invoice/save")
	public Boolean save(@RequestBody String invoice);
	@RequestMapping("/invoice/update")
	public Boolean update(@RequestBody String invoice);
	@RequestMapping("/invoice/deleteById/{id}")
	public Boolean delete(@PathVariable Long id);
}
