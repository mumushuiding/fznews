package com.lt.cloud.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.cloud.pojo.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	Page<Invoice> findAll(Specification<Invoice> specification,Pageable pageable);
}
