package com.lt.cloud.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.lt.cloud.config.SettingsErrorCode;
import com.lt.cloud.pojo.adv.AdvorderReceiver;
import com.lt.cloud.service.OrderService;
import com.lt.cloud.utils.JsonUtils;
import reactor.core.publisher.Mono;
@RestController
@RefreshScope
@RequestMapping("/order")
@SessionAttributes(names="sysuser")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@RequestMapping("/save")
	public Mono<String> save(@RequestBody String json) {
		try {
			this.orderService.save(json);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	@RequestMapping("/findById/{id}")
	public Mono<String> findById(@PathVariable Long id) {
		return Mono.just(JsonUtils.getGson().toJson(this.orderService.findById(id)));
	}
	@RequestMapping("/findAll")
	public Mono<String> findAll(@RequestBody String receiver) {
		return this.orderService.findAll(receiver);
	}
	@RequestMapping("/delete/{id}")
	public Mono<String> delete(@PathVariable Long id){
		return this.orderService.deleteOrderById(id)==true?Mono.just(SettingsErrorCode.SERVER_SUCCESS):Mono.just(SettingsErrorCode.SERVER_ERROR);
	}
}
