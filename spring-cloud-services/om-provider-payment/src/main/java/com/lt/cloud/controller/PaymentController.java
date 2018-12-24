package com.lt.cloud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lt.cloud.dao.jpa.CollectionModeRepository;
import com.lt.cloud.pojo.CollectionMode;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;
import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private CollectionModeRepository collectionModeRepository;
	@RequestMapping("/findAll")
	public Mono<String> selectAllPayment(@RequestBody String json) {
		PaymentReceive receive=JsonUtils.getGson().fromJson(json, PaymentReceive.class);
		Pageable pageable=PageRequest.of(receive.getPageIndex()==null?0:(receive.getPageIndex()-1), receive.getPageSize()==null?15:receive.getPageSize());
		Page<Payment> page=this.paymentService.findAll(receive, pageable);
		return Mono.just(JsonUtils.formatPageForPagination(page));
	}
	@RequestMapping("/findAllCollectionMode")
	public Mono<String> findAllCollectionMode(){
		List<CollectionMode> modes=this.collectionModeRepository.findAll();
		return Mono.just(JsonUtils.getGson().toJson(modes)).retry();
	}
	@RequestMapping("/save")
	public Mono<Boolean> save(@RequestBody String json) {
		this.paymentService.save(json);
		return Mono.just(true);
	}
	@RequestMapping("/update")
	public Mono<Boolean> update(@RequestBody String json){
		
		return Mono.just(this.paymentService.update(json));
	}
	@RequestMapping("/updateInvoice")
	public Mono<Boolean> updateInvoice(@RequestBody String json){
		
		return Mono.just(this.paymentService.updateInvoice(json));
	}
	@RequestMapping("/findById/{id}")
	public Mono<String> findById(@PathVariable Long id){
		return Mono.just(JsonUtils.getGson().toJson(this.paymentService.findById(id)));
	}
	@RequestMapping("/deleteById/{id}")
	public Mono<Boolean> deleteById(@PathVariable Long id) {
		try {
			this.paymentService.deleteById(id);
			return Mono.just(true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@RequestMapping("/deleteInvoice")
	public Mono<Boolean> deleteInvoice(@RequestBody String json) {
		try {
			this.paymentService.deleteInvoice(json);
			return Mono.just(true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
