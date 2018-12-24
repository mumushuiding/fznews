package com.lt.cloud.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;
public interface RebateService {
	Page<Rebate> findAll(RebateReceive rebateReceive,Pageable pageable);
	
	Page<Rebate> findAllRebate(RebateReceive rebateReceive,Pageable pageable);
	
	Boolean save(String rebate);
}
