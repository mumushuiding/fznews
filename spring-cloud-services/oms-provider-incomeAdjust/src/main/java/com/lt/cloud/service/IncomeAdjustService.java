package com.lt.cloud.service;

import org.springframework.data.domain.Page;

import com.lt.cloud.pojo.Incomeadjust;
import com.lt.cloud.pojo.IncomeajustReceiver;

public interface IncomeAdjustService {
	Page<Incomeadjust> findAll(IncomeajustReceiver receiver);
}
