package com.lt.cloud.service;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.AdvOrg;
import com.lt.cloud.pojo.AdvTrade;

public interface AdvOrgService {
	List<AdvOrg> selectAllAdvOrg(HashMap<String, Object> params);
	List<AdvTrade> selectAllTrade(HashMap<String, Object> params);
}
