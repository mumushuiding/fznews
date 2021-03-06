package com.lt.cloud.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.lt.cloud.annotation.NoRepeatSubmit;
import com.lt.cloud.config.SettingsErrorCode;
import com.lt.cloud.pojo.adv.AdvotherReceiver;
import com.lt.cloud.service.AdvService;
import com.lt.cloud.utils.JsonUtils;
import reactor.core.publisher.Mono;



@RefreshScope
@Controller
@SessionAttributes("sysuser")
public class AdvController {
	@Autowired
	private AdvService advService;
	@PostMapping("/adv/saveAdv")
	@NoRepeatSubmit
	@ResponseBody
	public String save(@RequestBody String advitems) throws UnsupportedEncodingException {

		return this.advService.save(advitems)==true?"{\"code\":200,\"message\":\"操作成功!\"}":SettingsErrorCode.SERVER_ERROR;
	}
	@RequestMapping("/adv/deleteAdvitem/{id}")
	@NoRepeatSubmit
	@ResponseBody
	public String deleteAdvitem(@PathVariable Long id) {
		return this.advService.deleteById(id)==true?"{\"code\":200,\"message\":\"操作成功!\"}":SettingsErrorCode.SERVER_ERROR;
	}
	@RequestMapping("/advitem/findAll")
	@ResponseBody
	public Mono<String> findAll(@RequestBody String receiver) {

		return this.advService.findAll(receiver);
	}
	
	/**
	 *    传入参数week和E_PID
	 * @param receiver
	 * @return
	 */
	@RequestMapping("/advother/pricemarketday")
	@ResponseBody
	public Mono<String> selectPricemarketday(@RequestBody AdvotherReceiver receiver) {
		List<String> weeks=Arrays.asList("E_Mon","E_Tues","E_Wed","E_Thur","E_Fri","E_Sat","E_Sun");
		receiver.setTable("pricemarketday");
		receiver.setField(weeks.get(receiver.getWeek()-1));

		String result=this.advService.selectAllAdvother(receiver);
		
		return Mono.just(result);
		
	}
	@RequestMapping("/advother/selectAll")
	@ResponseBody
	public Mono<String> selectAll(@RequestBody String json) {
		AdvotherReceiver receiver=JsonUtils.getGson().fromJson(json, AdvotherReceiver.class);
		System.out.println(JsonUtils.getGson().toJson(receiver));
		return Mono.just(this.advService.selectAllAdvother(receiver));
		
	}
	@RequestMapping("/advitem/selectById/{id}")
	@ResponseBody
	public String selectById(@PathVariable Long id) {
		return this.advService.selectById(id);
	}
	/**
	 * 
	 * @param E_PID 刊物
	 * @param E_MID 投放日ID 
	 * @param E_AdField_ID 版位
	 * @param E_Color_ID	颜色
	 * @param E_AdSize_ID	规格
	 * @return
	 */
	@RequestMapping("/pricelistitem/selectAll")
	@ResponseBody
	public String selectAllPricelistitem(@RequestBody String json) {
		AdvotherReceiver receiver=JsonUtils.getGson().fromJson(json, AdvotherReceiver.class);
		System.out.println(JsonUtils.getGson().toJson(receiver));
		return this.advService.selectAllPricelistitem(receiver);
	}
}
