package com.lt.cloud.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.cloud.pojo.Incomeadjust;

public interface IncomeAdjustRepository extends JpaRepository<Incomeadjust, Long>{
	Page<Incomeadjust> findAll(Specification<Incomeadjust> specification,Pageable pageable);
}
