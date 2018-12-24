package com.lt.cloud.service;

import java.util.HashMap;


import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;


public interface PaymentService {
	public String selectAllPayment(HashMap<String, Object> params);
	public String findAll(String receive);
	public String findAllCollectionMode();
	public Boolean save(String payment);
	public Payment findById(Long id);
	public Boolean update(String invoice);
	public Boolean updateInvoice(String invoice);
	public Boolean deleteInvoice(String json);
	public void deleteById(Long id);
	public void updateAndBalanceReal(String json);
	public void moneyback(String json);
}
