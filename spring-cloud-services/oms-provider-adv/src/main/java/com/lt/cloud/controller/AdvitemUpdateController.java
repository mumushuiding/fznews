package com.lt.cloud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.reflect.TypeToken;
import com.lt.cloud.annotation.NoRepeatSubmit;
import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.service.AdvitemUpdateSevice;
import com.lt.cloud.utils.JsonUtils;
import com.netflix.client.http.HttpRequest;

import reactor.core.publisher.Mono;

@RestController
@RefreshScope
@RequestMapping("/advitem")
public class AdvitemUpdateController {
	
	@Autowired
	private AdvitemUpdateSevice advitemUpdateSevice;
	@RequestMapping("/saveAll")
	public Mono<Boolean> saveAll(@RequestBody String advitem) {
		List<Advitem> advitems=JsonUtils.getGson().fromJson(advitem, new TypeToken<List<Advitem>>() {}.getType());
		try {
			this.advitemUpdateSevice.saveAll(advitems);
			return Mono.just(true);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@RequestMapping("/updateAll")
	public Mono<Boolean> updateAll(@RequestBody String advitemList){
		List<Advitem> advitems=JsonUtils.getGson().fromJson(advitemList, new TypeToken<List<Advitem>>() {}.getType());
		this.advitemUpdateSevice.updateAll(advitems);
		return Mono.just(true);
	}
	@RequestMapping("/insertAdvitem")
	public Advitem insertAdvitem(@RequestBody Advitem advitem) {
		try {
			this.advitemUpdateSevice.insertAdvdoc(advitem);
			if(advitem.getAI_ArticleID()==null) {
				throw new RuntimeException("插入advdoc失败，服务不可用，请稍后再尝试，若仍然失败，请联系管理员");
			}
			return this.advitemUpdateSevice.insertAdvitem(advitem);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	@RequestMapping("/deleteAdvitem/{id}")
	public Boolean deleteAdvitem(@PathVariable Long id) {
		this.advitemUpdateSevice.deleteById(id);
		return true;
	}
	@RequestMapping("/deleteByOrderId/{id}")
	public Mono<Boolean> deleteByOrderId(@PathVariable Long id) {
		try {
			this.advitemUpdateSevice.deleteByOrderId(id);
			return Mono.just(true);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@RequestMapping("/updateAdvitem")
	public Long updateAdvitem(@RequestBody Advitem advitem) {
		try {
			return this.advitemUpdateSevice.updateAdvitem(advitem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0L;
	}
}
