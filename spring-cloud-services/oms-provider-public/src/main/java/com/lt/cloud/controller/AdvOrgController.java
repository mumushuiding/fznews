package com.lt.cloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lt.cloud.pojo.AdvOrg;
import com.lt.cloud.pojo.AdvTrade;
import com.lt.cloud.service.AdvOrgService;
import com.lt.cloud.utils.JsonUtils;

@RefreshScope
@RestController
public class AdvOrgController {
	@Autowired
	private AdvOrgService advOrgService;
	@RequestMapping("/advTrade/catTree")
	public String getAdvTradeTree() {
		List<AdvTrade> list=advOrgService.selectAllTrade(new HashMap<>());
		List<AdvTrade> list2=new ArrayList<>();
		for (AdvTrade advOrg3:list) {
			
			AdvTrade advOrg=(AdvTrade) advOrg3.clone();

			for (AdvTrade advOrg2:list) {

				if(advOrg2.insertIfIsParent(advOrg, advOrg2)) {
					list2.add(advOrg3);
				}

			}
			
		}

		for (AdvTrade advOrg : list2) {
			list.remove(advOrg);
		}
		for (AdvTrade advOrg : list) {
			advOrg.operation();
		}

		return JsonUtils.getGson().toJson(list);
	}
	@RequestMapping("/advOrg/catTree")
	public String getCatTree() {
		List<AdvOrg> list=advOrgService.selectAllAdvOrg(new HashMap<>());
		List<AdvOrg> list2=new ArrayList<>();
		
		for (AdvOrg advOrg3:list) {

			AdvOrg advOrg=(AdvOrg) advOrg3.clone();

			for (AdvOrg advOrg2:list) {

				if(advOrg2.insertIfIsParent(advOrg, advOrg2)) {
					list2.add(advOrg3);
				}

			}
			
		}

		for (AdvOrg advOrg : list2) {
			list.remove(advOrg);
		}
//		for (AdvOrg advOrg : list) {
//			advOrg.operation();
//		}

		return JsonUtils.getGson().toJson(list);
	}
}
