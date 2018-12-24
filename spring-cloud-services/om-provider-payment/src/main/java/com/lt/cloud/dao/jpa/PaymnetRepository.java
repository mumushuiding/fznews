package com.lt.cloud.dao.jpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;

public interface PaymnetRepository extends JpaRepository<Payment,Long>{
	Page<Payment> findAll(Specification<PaymentReceive> spec,Pageable pageable);
	List<Payment> findByPinvoicenoContaining(String pinvoiceno);
	
}
