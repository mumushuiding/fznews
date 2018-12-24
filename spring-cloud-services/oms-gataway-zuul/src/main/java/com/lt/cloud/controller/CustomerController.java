package com.lt.cloud.controller;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lt.cloud.config.SettingsErrorCode;
import com.lt.cloud.pojo.User;
import com.lt.cloud.pojo.customer.Customer;
import com.lt.cloud.service.CustomerService;
import com.lt.cloud.utils.JsonUtils;
import reactor.core.publisher.Mono;
@RefreshScope
@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@RequestMapping("/customer/insertCustomer")
	public String insertCustomer(Customer customer,
			HttpSession session,
			@RequestParam(required=false) String redirect) {
		User user=(User) session.getAttribute("sysuser");
		if(user==null) return "redirect:/user/loginForm";
		
		customer.setSYS_AUTHORS(user.getUSERNAME());
		customer.setSYS_CREATED(new Date());
		customer.setSYS_LASTMODIFIED(new Date());
		
		this.customerService.insertCustomer(customer);
		
		return "redirect:"+redirect;
	}
	@RequestMapping("/customer/save")
	public Mono<String> save(@RequestBody String json){
		Customer customer=JsonUtils.getGson().fromJson(json, Customer.class);
		customer.setSYS_CREATED(new Date());
		customer.setSYS_LASTMODIFIED(new Date());
		try {
			this.customerService.insertCustomer(customer);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@RequestMapping("/customer/updateCustomer")
	public String iupdateCustomer(Customer customer,
			@RequestParam(required=false) String redirect) {
		customer.setSYS_LASTMODIFIED(new Date());
		this.customerService.updateCustomer(customer);
		
		return "redirect:"+redirect;
	}
	@RequestMapping("/customer/selectAll")
	public String selectAll(Integer page,Integer rows,
			@RequestParam(required=false) String customerName){
		
		return this.customerService.selectAllCustomer(page, rows, customerName);
	}
	@RequestMapping("/customer/autoCompleteForEasyui")
	public String autoCompleteForEasyui(Integer pageSize,
			@RequestParam(required=false) String CUST_NAME) {
		return this.customerService.autoCompleteForEasyui(pageSize, CUST_NAME);
	}
	@RequestMapping("/customer/find4AutoComplete")
	public String find4AutoComplete(@RequestBody String  customerReceiver) {
		
		return this.customerService.find4AutoComplete(customerReceiver);
	}
	@RequestMapping("/salesman/find4AutoComplete/{name}")
	public String salesmanfind4AutoComplete(@PathVariable String name) {
		return this.customerService.salesmanfind4AutoComplete(name);
	}
	@RequestMapping("/salesman/save")
	public Mono<String> saveSalesman(@RequestBody String json) {
		try {
			this.customerService.saveSalesman(json);
			return Mono.just(SettingsErrorCode.SERVER_SUCCESS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
