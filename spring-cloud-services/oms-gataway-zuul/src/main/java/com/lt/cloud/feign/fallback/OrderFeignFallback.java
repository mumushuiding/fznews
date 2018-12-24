package com.lt.cloud.feign.fallback;

import org.springframework.stereotype.Component;

import com.lt.cloud.feign.OrderFeignClient;
import com.lt.cloud.pojo.adv.AdvorderReceiver;
@Component
public class OrderFeignFallback implements OrderFeignClient{

	@Override
	public String findAll(String receiver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean save(String advorder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateAllWithAdvitem(String advitems) {
		System.out.println("进入断路器-save。。。");
        throw new RuntimeException("更新失败");
	}

	@Override
	public String findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
