package com.lt.cloud.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codingapi.tx.annotation.TxTransaction;
import com.lt.cloud.feign.InvoiceFeignClient;
import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;
import com.lt.cloud.pojo.PojosWrapper;
import com.lt.cloud.service.InvoiceService;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;
@Component
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceFeignClient invoiceFeignClient;
	@Autowired
	private PaymentService paymentService;
	@Override
	public String findAll(HashMap<String, Object> params) {
		
		return this.invoiceFeignClient.findAll(params);
	}
	@Override
	public String findAll(String receiver) {
		
		return this.invoiceFeignClient.findAll(receiver);
	}

	@Override
	@TxTransaction
	public Boolean save(String invoice) {
		return this.invoiceFeignClient.save(invoice);
	}
	@Override
	@TxTransaction
	public Boolean delete(Long id) {
		
		return this.invoiceFeignClient.delete(id);
	}
	@Override
	@TxTransaction(isStart=true)
	public boolean saveNew(String json) {
		PojosWrapper pojosWrapper=JsonUtils.getGson().fromJson(json, PojosWrapper.class);
		//添加发票
		Boolean invoiceres=this.save(JsonUtils.getGson().toJson(pojosWrapper.getInvoice()));
		//添加或者更新收款
		Boolean paymentres=false;
		if (pojosWrapper.getPayment()!=null) {
			if (pojosWrapper.getPayment().getSYS_DOCUMENTiD()==null) {
				paymentres=this.paymentService.save(JsonUtils.getGson().toJson(pojosWrapper.getPayment()));
			}else {
				paymentres=this.paymentService.updateInvoice(JsonUtils.getGson().toJson(pojosWrapper.getPayment()));
			}
		}
		
		return invoiceres&&paymentres;
	}
	@Override
	@TxTransaction(isStart=true)
	public boolean deleteInvoice(String json) {
		PojosWrapper pojosWrapper=JsonUtils.getGson().fromJson(json, PojosWrapper.class);
		//删除发票
		Boolean invoiceres=this.delete(pojosWrapper.getInvoice().getSYS_DOCUMENTID());
		//修正收款
		Boolean paymentres=this.paymentService.deleteInvoice(JsonUtils.getGson().toJson(pojosWrapper.getPayment()));
		return invoiceres&&paymentres;
	}
	@Override
	@TxTransaction
	public Boolean update(String invoice) {
		
		return this.invoiceFeignClient.update(invoice);
	}

}
