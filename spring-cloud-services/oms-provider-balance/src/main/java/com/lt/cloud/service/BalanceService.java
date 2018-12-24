package com.lt.cloud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.BalanceReceiver;

public interface BalanceService {
	Page<Balance> findAll(BalanceReceiver balanceReceiver);
	/**
	 * 找出所有可以反平帐的订单
	 * @param balanceReceiver
	 * @return
	 */
	List<Balance> findAllReversable(Long payid);
	List<Balance> findAllReversable(BalanceReceiver receiver);
	Boolean saveAll(String json);
	/**
	 * 根据收款号在平帐表中查询不重复的订单，并且订单的平帐总金额必须大于0,查询结果有两个字段：广告ID和平帐金额
	 * @param B_PayID
	 * @return
	 */
	List<Balance> findByPayIdResultAdv(Long B_PayID);
}
