package com.lt.cloud.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lt.cloud.pojo.Advitem;
@Transactional
public interface AdvitemUpdateSevice {
	
	Advitem insertAdvitem(Advitem advitem);
	Long insertAdvdoc(Advitem advitem);
	
	Long updateAdvitem(Advitem advitem);
	Long updateAdvdoc(Advitem advitem);
	Boolean saveAll(List<Advitem> advitems);
	void deleteById(Long id);
	void updateAll(List<Advitem> advitems);
	void deleteByOrderId(Long id);
	Advitem findById(Long id);
	
}
