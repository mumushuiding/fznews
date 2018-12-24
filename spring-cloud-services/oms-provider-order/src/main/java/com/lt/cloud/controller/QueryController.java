package com.lt.cloud.controller;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.crypto.ec.ECNewPublicKeyTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.pojo.Advorder;
import com.lt.cloud.pojo.AdvorderReceiver;
import com.lt.cloud.service.OrderQueryService;
import com.lt.cloud.utils.JsonUtils;
import com.netflix.client.http.HttpRequest;

import reactor.core.publisher.Mono;
@RestController
@RefreshScope
@RequestMapping("/order")
public class QueryController {
//	@Autowired
//    private HttpServletRequest servletRequest;
	@Autowired
	private OrderQueryService orderQueryService;
	@RequestMapping("/findById/{id}")
	public Mono<String> selectById(@PathVariable Long id) {
		return Mono.just(JsonUtils.getGson().toJson(this.orderQueryService.findById(id)));
	}
	@RequestMapping("/findAll")
	public Mono<String> findAll(@RequestBody String json) {
		AdvorderReceiver receiver=JsonUtils.getGson().fromJson(json, AdvorderReceiver.class);
		Page<Advorder> page=this.orderQueryService.findAll(receiver);
		return Mono.just(JsonUtils.formatPageForPagination(page));
	}
	@RequestMapping("/save")
	public Mono<Boolean> save(@RequestBody String json){
		Advorder advorder=JsonUtils.getGson().fromJson(json, Advorder.class);
		if (advorder.getSYS_DOCUMENTID()==null) {
			advorder.setSYS_CREATED(new Date());
		}
		advorder.setSYS_LASTMODIFIED(new Date());
		this.orderQueryService.save(advorder);
		return Mono.just(true);
	}
	
	@RequestMapping("/deleteById/{id}")
	public Mono<Boolean> deleteById(@PathVariable Long id) {
		this.orderQueryService.deleteById(id);
		return Mono.just(true);
	}
	@PostMapping("/updateAllWithAdvitem")
	public Mono<Boolean> updateAllWithAdvitem(@RequestBody String advitems) {
		this.orderQueryService.updateAllWithAdvitem(advitems);
		return Mono.just(true);
		
	}

}
