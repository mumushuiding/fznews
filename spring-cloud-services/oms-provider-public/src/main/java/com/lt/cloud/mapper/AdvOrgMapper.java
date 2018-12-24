package com.lt.cloud.mapper;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.AdvOrg;
import com.lt.cloud.pojo.AdvTrade;

public interface AdvOrgMapper {
	List<AdvOrg> selectAllAdvOrg(HashMap<String, Object> params);
	List<AdvTrade> selectAllTrade(HashMap<String, Object> params);
}
