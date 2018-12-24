package com.lt.cloud.service;
import java.util.List;

import org.springframework.data.domain.Page;
import com.lt.cloud.pojo.Advorder;
import com.lt.cloud.pojo.AdvorderReceiver;

public interface OrderQueryService {
	Page<Advorder> findAll(AdvorderReceiver receiver);
	Advorder findById(Long id);
	
	Advorder save(Advorder advOrder);
	Advorder update(Advorder advOrder);
	
	void updateAllWithAdvitem(String advitemList);
	void deleteById(Long id);

}
