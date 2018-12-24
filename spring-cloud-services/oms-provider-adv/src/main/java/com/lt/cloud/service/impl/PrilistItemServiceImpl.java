package com.lt.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.mapper.PricelistitemMapper;
import com.lt.cloud.pojo.AdvotherReceiver;
import com.lt.cloud.pojo.Pricelistitem;
import com.lt.cloud.service.PrilistItemService;
@Component
public class PrilistItemServiceImpl implements PrilistItemService{
	@Autowired
	private PricelistitemMapper pricelistitemMapper;
	@Override
	public List<Pricelistitem> selectAll(AdvotherReceiver receiver) {
		
		return this.pricelistitemMapper.selectAll(receiver);
	}
}
