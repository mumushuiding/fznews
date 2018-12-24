package com.lt.cloud.service;
import java.util.HashMap;


import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.pojo.adv.AdvitemReceiver;
import com.lt.cloud.pojo.adv.AdvotherReceiver;

import reactor.core.publisher.Mono;
public interface AdvService {
	
	public Mono<String> findAll(String receiver);
	public String findById(Long id);
	public String selectAllAdvitem(Integer pageIndex,Integer pageSize,HashMap<String, Object> params);
	public Advitem insertAdvitem(Advitem advitem);

	public String selectAllAdvother(AdvotherReceiver receiver);
	
	public String selectById(Long id);
	
	public Advitem selectAdvItemById(Long id);
	
	public Long updateAdvitem(Advitem advitem);
	
	public Boolean deleteAdvitem(Long id);
	
	public String selectAllPricelistitem(AdvotherReceiver receiver);
	public Boolean save(String advitems);
	public Boolean saveAll(String advitems);
	
	public Boolean updateAll(String advitems);
	public Boolean deleteByOrderId(Long id);
	public Boolean deleteById(Long id);
}
