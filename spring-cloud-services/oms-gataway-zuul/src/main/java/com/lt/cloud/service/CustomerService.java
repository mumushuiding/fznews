package com.lt.cloud.service;
import com.lt.cloud.pojo.customer.Customer;
public interface CustomerService {
	
	public String selectById(Long id);
	
	public Customer selectCustomerById(Long id);
	
	public String autoCompleteForEasyui(Integer pageSize,String CUST_NAME);
	
	public String selectAllCustomer(Integer pageIndex,Integer pageSize,String CUST_NAME);
	
	public String find4AutoComplete(String customerReceiver);

	public void insertCustomer(Customer customer);

	public void updateCustomer(Customer customer);
	
	public String salesmanfind4AutoComplete(String name);

	public void saveSalesman(String json);

}
