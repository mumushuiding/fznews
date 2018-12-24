package com.lt.cloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PojosWrapper;
import com.lt.cloud.utils.JsonUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OmsGatawayZuulApplicationTests {

	@Test
	public void contextLoads() {
		Invoice invoice=new Invoice();
		Payment payment=new Payment();
		invoice.setCustomer("aaaaaaaaaaaaa");
		payment.setP_publication("收款");
		PojosWrapper pojosWrapper=new PojosWrapper();
		pojosWrapper.setInvoice(invoice);
		pojosWrapper.setPayment(payment);
		System.out.println(JsonUtils.getGson().toJson(pojosWrapper));
	}

}
