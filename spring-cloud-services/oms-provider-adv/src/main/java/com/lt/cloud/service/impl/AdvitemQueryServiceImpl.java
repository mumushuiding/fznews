package com.lt.cloud.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.mapper.AdvitemMapper;
import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.pojo.AdvitemReceiver;
import com.lt.cloud.service.AdvitemQueryService;
@Component
public class AdvitemQueryServiceImpl implements AdvitemQueryService{
	@Autowired
	private AdvitemMapper advitemMapper;
	@Override
	public HashMap<String, Object> setParams(String AI_Customer, String AI_Agent, String AI_Advertiser,
			Long AI_Customer_ID, Long AI_Agent_ID, Long AI_Advertiser_ID, String AI_PublishTime,
			String AI_PublishEndTime, String AI_Trade) {
		HashMap<String, Object> params=new HashMap<>();
		if(AI_Customer!=null)params.put("AI_Customer", AI_Customer);
		if(AI_Agent!=null)params.put("AI_Agent",AI_Agent );
		if(AI_Advertiser!=null)params.put("AI_Advertiser", AI_Advertiser);
		if(AI_Customer_ID!=null)params.put("AI_Customer_ID", AI_Customer_ID);
		if(AI_Agent_ID!=null)params.put("AI_Agent_ID", AI_Agent_ID);
		if(AI_Advertiser_ID!=null)params.put("AI_Advertiser_ID", AI_Advertiser_ID);
		if(AI_PublishTime!=null)params.put("AI_PublishTime", AI_PublishTime);
		if(AI_PublishEndTime!=null)params.put("AI_PublishEndTime", AI_PublishEndTime);
		if(AI_Trade!=null)params.put("AI_Trade", AI_Trade);
		
		return params;
	}

	@Override
	public List<Advitem> selectAllAdvitem(HashMap<String, Object> params) {
		
		return this.advitemMapper.selectAllAdvitem(params);
	}

	@Override
	public List<Advitem> selectAllAdvitem(Advitem advitem) {
		return this.advitemMapper.selectAllAdvitem(advitem);
	}

	@Override
	public Advitem selectById(long id) {
		
		return this.advitemMapper.selectById(id);
	}

	@Override
	public List<Advitem> findAll(AdvitemReceiver receiver) {
		
		return this.advitemMapper.findAll(receiver);
	}

}
