package com.lt.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.mapper.CustomerMapper;
import com.lt.cloud.pojo.Customer;
import com.lt.cloud.service.CustomerService;
@Component
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public Long insertCustomer(Customer customer) {
		
		return this.customerMapper.insertCustomer(customer);
	}

	@Override
	public Long updateCustomer(Customer customer) {
		
		return this.customerMapper.updateCustomer(customer);
	}

}
