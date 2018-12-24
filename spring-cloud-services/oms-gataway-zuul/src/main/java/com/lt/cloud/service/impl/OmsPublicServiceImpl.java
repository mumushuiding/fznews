package com.lt.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.feign.OmsPublicFeighnClient;
import com.lt.cloud.service.OmsPublicService;
@Component
public class OmsPublicServiceImpl implements OmsPublicService{
	@Autowired
	private OmsPublicFeighnClient omsPublicFeighnClient;

	@Override
	public String getCatTree() {
		
		return this.omsPublicFeighnClient.getCatTree();
	}

	@Override
	public String getTradeTree() {
		
		return this.omsPublicFeighnClient.getAdvTradeTree();
	}
	
}
