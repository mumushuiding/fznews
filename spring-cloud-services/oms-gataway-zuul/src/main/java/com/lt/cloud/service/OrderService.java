package com.lt.cloud.service;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.pojo.adv.Advorder;
import com.lt.cloud.pojo.adv.AdvorderReceiver;

import reactor.core.publisher.Mono;
public interface OrderService {
	
	public Mono<String> findAll(String receiver);
	public Advorder findById(Long id);
	public Boolean save(String advorder);
	public Boolean updateAllWithAdvitem(String advitems);
	public Boolean deleteAdvitem(Advitem advitem);
	public Boolean deleteById(Long id);
	public boolean deleteOrderById(Long id);

}
