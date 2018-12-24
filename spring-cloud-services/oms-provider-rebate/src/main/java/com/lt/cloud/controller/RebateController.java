package com.lt.cloud.controller;



import java.time.Duration;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;
import com.lt.cloud.service.RebateService;

import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;


@RefreshScope
@RestController
@RequestMapping("/rebate")
public class RebateController {
	
	@Autowired
	private RebateService rebateService;
	@RequestMapping("/findAll")
	public Mono<String> findAll(@RequestBody RebateReceive rebateReceive){
		Pageable pageable=PageRequest.of(rebateReceive.getPageIndex()==null?0:(rebateReceive.getPageIndex()-1), rebateReceive.getPageSize()==null?15:rebateReceive.getPageSize());
		Page<Rebate> rebates=rebateService.findAll(rebateReceive,pageable);
		

		return Mono.just(JsonUtils.formatPageForPagination(rebates));
	}
	@RequestMapping("/save")
	public Mono<Boolean> save(@RequestBody String json) {

		boolean res=this.rebateService.save(json);
		return Mono.just(res);
	}
	@GetMapping("/sseTest")
	public Flux<ServerSentEvent<Integer>> randomNumbers(){
		return Flux.interval(Duration.ofSeconds(1))
				.map(seq->Tuples.of(seq, ThreadLocalRandom.current().nextInt()))
				.map(data->ServerSentEvent.<Integer>builder()
						.event("random")
						.data(data.getT2())
						.id(Long.toString(data.getT1()))
						.build());
	}
}
