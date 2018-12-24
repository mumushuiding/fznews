package com.lt.cloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.cloud.feign.customer.CustomerQueryFeign;
import com.lt.cloud.pojo.customer.Customer;
import com.lt.cloud.pojo.customer.CustomerReceiver;
import com.lt.cloud.service.CustomerService;
import com.lt.cloud.utils.JsonUtils;
@Component
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerQueryFeign customerQueryFeign;
	@Override
	public String selectById(Long id) {
		
		return this.customerQueryFeign.selectById(id);
	}

	@Override
	public String autoCompleteForEasyui(Integer pageSize, String CUST_NAME) {
	
		return this.customerQueryFeign.autoCompleteForEasyui(pageSize, CUST_NAME);
	}

	@Override
	public String selectAllCustomer(Integer pageIndex, Integer pageSize, String CUST_NAME) {
		
		return this.customerQueryFeign.selectAllCustomer(pageIndex, pageSize, CUST_NAME);
	}

	@Override
	public Customer selectCustomerById(Long id) {
		
		return JsonUtils.getGson().fromJson(this.selectById(id), Customer.class);
	}

	@Override
	public String find4AutoComplete(String customerReceiver) {
		
		return this.customerQueryFeign.find4AutoComplete(customerReceiver);
	}

	@Override
	public void insertCustomer(Customer customer) {
		this.customerQueryFeign.insertCustomer(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.customerQueryFeign.updateCustomer(customer);
		
	}

	@Override
	public String salesmanfind4AutoComplete(String name) {
		
		return this.customerQueryFeign.salesmanfind4AutoComplete(name);
	}

	@Override
	public void saveSalesman(String json) {
		this.customerQueryFeign.saveSalesman(json);
		
	}

}
