package com.lt.cloud.service;

import java.util.HashMap;

import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;

import reactor.core.publisher.Mono;


public interface InvoiceService {
	public String findAll(HashMap<String, Object> params);
	public String findAll(String receiver);
	public Boolean save(String invoice);
	public Boolean update(String invoice);
	public Boolean delete(Long id);
	public boolean saveNew(String json);
	public boolean deleteInvoice(String json);
}
