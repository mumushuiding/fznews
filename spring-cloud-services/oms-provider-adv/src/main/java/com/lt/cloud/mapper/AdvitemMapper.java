package com.lt.cloud.mapper;

import java.util.HashMap;
import java.util.List;

import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.pojo.AdvitemReceiver;

public interface AdvitemMapper {
	List<Advitem> findAll(AdvitemReceiver receiver);
	
	
	List<Advitem> selectAllAdvitem(HashMap<String, Object> params);
	List<Advitem> selectAllAdvitem(Advitem advitem);
	
	Advitem insertAdvitem(Advitem advitem);
	Long updateAdvitem(Advitem advitem);
	Long updateAdvdoc(Advitem advitem);
	Long insertAdvdoc(Advitem advitem);
	Long deleteById(Long id);
	Advitem selectById(long id);
	
}
