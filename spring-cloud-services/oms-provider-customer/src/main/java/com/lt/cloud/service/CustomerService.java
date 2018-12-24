package com.lt.cloud.service;

import com.lt.cloud.pojo.Customer;

public interface CustomerService {
	Long insertCustomer(Customer customer);
	Long updateCustomer(Customer customer);
}
