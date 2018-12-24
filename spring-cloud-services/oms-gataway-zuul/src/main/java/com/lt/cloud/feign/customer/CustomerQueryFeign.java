package com.lt.cloud.feign.customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lt.cloud.pojo.customer.Customer;
@FeignClient(name="oms-provider-customer")
public interface CustomerQueryFeign {
	@RequestMapping("/customer/selectById/{id}")
	public String selectById(@PathVariable Long id);
	@RequestMapping("/customer/autoCompleteForEasyui")
	public String autoCompleteForEasyui(@RequestParam(required=false) Integer pageSize,
			@RequestParam(required=false) String CUST_NAME);
	@GetMapping("/customer/selectAll")
	public String selectAllCustomer(@RequestParam(required=false) Integer pageIndex,@RequestParam(required=false) Integer pageSize,@RequestParam(required=false) String CUST_NAME);
	@RequestMapping("/customer/find4AutoComplete")
	public String find4AutoComplete(@RequestBody String customerReceiver);
	@RequestMapping("/customer/insertCustomer")
	public Long insertCustomer(@RequestBody Customer customer) ;
	@RequestMapping("/customer/updateCustomer")
	public Long updateCustomer(@RequestBody Customer customer) ;
	@RequestMapping("/salesman/find4AutoComplete/{name}")
	public String salesmanfind4AutoComplete(@PathVariable String name);
	@RequestMapping("/salesman/save")
	public void saveSalesman(@RequestBody String json);
}
