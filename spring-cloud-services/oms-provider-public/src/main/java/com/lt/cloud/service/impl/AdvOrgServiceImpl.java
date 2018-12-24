package com.lt.cloud.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.mapper.AdvOrgMapper;
import com.lt.cloud.pojo.AdvOrg;
import com.lt.cloud.pojo.AdvTrade;
import com.lt.cloud.service.AdvOrgService;
@Component
public class AdvOrgServiceImpl implements AdvOrgService{
	@Autowired
	private AdvOrgMapper advOrgMapper;
	@Override
	public List<AdvOrg> selectAllAdvOrg(HashMap<String, Object> params) {
		
		return this.advOrgMapper.selectAllAdvOrg(params);
	}
	@Override
	public List<AdvTrade> selectAllTrade(HashMap<String, Object> params) {
		
		return this.advOrgMapper.selectAllTrade(params);
	}

}
