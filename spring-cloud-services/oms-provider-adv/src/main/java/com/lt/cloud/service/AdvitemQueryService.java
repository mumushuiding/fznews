package com.lt.cloud.service;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.pojo.AdvitemReceiver;

public interface AdvitemQueryService {
	HashMap<String, Object> setParams(String AI_Customer,String AI_Agent,String AI_Advertiser,
			Long AI_Customer_ID,Long AI_Agent_ID,Long AI_Advertiser_ID,String AI_PublishTime,
			String AI_PublishEndTime,String AI_Trade);
	List<Advitem> selectAllAdvitem(HashMap<String, Object> params);
	List<Advitem> selectAllAdvitem(Advitem advitem);
	List<Advitem> findAll(AdvitemReceiver receiver);
	Advitem selectById(long id);
}
