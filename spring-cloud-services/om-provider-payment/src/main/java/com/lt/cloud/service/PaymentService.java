package com.lt.cloud.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;

public interface PaymentService {
	Page<Payment> findAll(PaymentReceive paymentReceive,Pageable pageable);
	Payment save(Payment payment);
	Payment findById(Long id);
	Boolean update(String json);
	Boolean updateInvoice(String json);
	void deleteInvoice(String json);
	void deleteById(Long id);
	void save(String json);

}
