package com.lt.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.cloud.pojo.Customer;
import com.lt.cloud.service.CustomerService;

@RestController
@RefreshScope
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/customer/insertCustomer")
	public Long insertCustomer(@RequestBody Customer customer) {
		return this.customerService.insertCustomer(customer);
	}
	@RequestMapping("/customer/updateCustomer")
	public Long updateCustomer(@RequestBody Customer customer) {
		return this.customerService.updateCustomer(customer);
	}
}
