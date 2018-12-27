package com.lt.cloud.controller;
import java.util.List;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;
import com.lt.cloud.service.InvoiceService;
import com.lt.cloud.stream.InvoiceProcessor;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RefreshScope
@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	@RequestMapping("/findAll")
	public Mono<String> findAll(@RequestBody String json){
		InvoiceReceiver invoiceReceiver=JsonUtils.getGson().fromJson(json, InvoiceReceiver.class);
		Page<Invoice> page=invoiceService.findAll(invoiceReceiver);
		return Mono.just(JsonUtils.formatPageForPagination(page));
	}
	@RequestMapping("/save")
	public Mono<Boolean> save(@RequestBody String json){
		Invoice invoice=JsonUtils.getGson().fromJson(json, Invoice.class);
		this.invoiceService.save(invoice);
		return Mono.just(true);
		
	}
	@RequestMapping("/update")
	public Mono<Boolean> update(@RequestBody String json){
		this.invoiceService.update(json);
		return Mono.just(true);
	}
	@RequestMapping("/deleteById/{id}")
	public Mono<Boolean> deleteById(@PathVariable Long id) {
		try {
			this.invoiceService.deleteById(id);
			return Mono.just(true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
