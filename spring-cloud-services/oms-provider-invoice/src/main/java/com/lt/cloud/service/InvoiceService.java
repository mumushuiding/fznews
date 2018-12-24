package com.lt.cloud.service;
import org.springframework.data.domain.Page;
import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;
public interface InvoiceService {
	Page<Invoice> findAll(InvoiceReceiver invoiceReceiver);
	Invoice save(Invoice invoice);
	Invoice test(Invoice invoice);
	Invoice findById(Long id);
	void deleteById(Long id);
	void update(String json);
}
