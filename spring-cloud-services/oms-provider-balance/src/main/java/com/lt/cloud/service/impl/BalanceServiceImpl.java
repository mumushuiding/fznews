package com.lt.cloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.druid.util.lang.Consumer;
import com.codingapi.tx.annotation.TxTransaction;
import com.google.gson.reflect.TypeToken;
import com.lt.cloud.dao.jpa.BalanceRepository;
import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.BalanceReceiver;
import com.lt.cloud.service.BalanceService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rx.Observable;

@Component
public class BalanceServiceImpl implements BalanceService{
	@Autowired
	private BalanceRepository balanceRepository;
	@Override
	public Page<Balance> findAll(BalanceReceiver balanceReceiver) {
		Specification<Balance> specification=new Specification<Balance>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Balance> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates=new ArrayList<>();
				if (balanceReceiver.getAditemid()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("aditemid"), balanceReceiver.getAditemid()));
				}
				if (!StringUtils.isEmpty(balanceReceiver.getCustomer())) {
					predicates.add(criteriaBuilder.like(root.get("customer"), "%"+balanceReceiver.getCustomer()+"%"));
				}
				if (!StringUtils.isEmpty(balanceReceiver.getB_Salesman())) {
					predicates.add(criteriaBuilder.like(root.get("B_Salesman"), balanceReceiver.getB_Salesman()));
				}
				if (!StringUtils.isEmpty(balanceReceiver.getSYS_AUTHORS())) {
					predicates.add(criteriaBuilder.like(root.get("SYS_AUTHORS"), balanceReceiver.getSYS_AUTHORS()));
				}
				if(balanceReceiver.getOrderid()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("orderid"), balanceReceiver.getOrderid()));
				}
				if (balanceReceiver.getB_PayID()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("B_PayID"), balanceReceiver.getB_PayID()));
				}
				if (balanceReceiver.getPublishtimeStart()!=null) {
					predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("publishtimeStart"), balanceReceiver.getPublishtimeStart()));
				}
				if (balanceReceiver.getPublishtimeEnd()!=null) {
					predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("publishtimeEnd"), balanceReceiver.getPublishtimeEnd()));
				}
				if (balanceReceiver.getSYS_CREATEDSTART()!=null) {
					predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("SYS_CREATEDSTART"), balanceReceiver.getSYS_CREATEDSTART()));
				}
				if (balanceReceiver.getSYS_CREATEDEND()!=null) {
					predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("SYS_CREATEDEND"), balanceReceiver.getSYS_CREATEDEND()));
				}
				List<Order> orders=new ArrayList<>();
				orders.add(criteriaBuilder.desc(root.get("SYS_LASTMODIFIED")));
				return query.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orders).getRestriction();
			}
		};
		return this.balanceRepository.findAll(specification,
				PageRequest.of(balanceReceiver.getPageIndex()==null?0:(balanceReceiver.getPageIndex()-1), 
						balanceReceiver.getPageSize()==null?15:balanceReceiver.getPageSize()));
	}
	@Override
	@TxTransaction
	@Transactional
	public Boolean saveAll(String json) {
		List<Balance> balances=JsonUtils.getGson().fromJson(json, new TypeToken<List<Balance>>() {}.getType());
		try {
			balances.stream().map(balance->{
				if (balance.getSYS_DOCUMENTID()==null) {
					balance.setSYS_CREATED(new Date());
				}
				balance.setSYS_LASTMODIFIED(new Date());
				//修改开票金额
				if(balance.getB_AmountInvoiced()==null) balance.setB_AmountInvoiced(0.0);
				balance.setB_AmountUninvoiced(balance.getB_Amount()-balance.getB_AmountInvoiced());
				return balance;
			}).forEach(this.balanceRepository::save);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 将结果中转换成不重复的广告
	 * @param list
	 * @return
	 */
	private List<Balance> findRerversable1(List<Balance> list){
		if(list.size()==0) return null;
		List<Balance> result=new ArrayList<>();
		list.stream().map(item->item.getB_AdItemID()).distinct().forEach(item2 -> {
			Balance balance=null;
			for (Balance balance2 : list) {
				if (balance2.getB_AdItemID().equals(item2)) {
					balance=balance2;
					break;
				}
			}
			//不重复的广告ID，和对应的平账总额
			Double sum=list.stream().filter(item3->item3.getB_AdItemID().equals(item2))
					.map(item4->item4.getB_Amount())
					.reduce((acc,cur)->acc+cur).get();
			if(sum>0) {
				balance.setB_Amount(sum);
				result.add(balance);
			}
		});
		return result;
	}
	@Override
	public List<Balance> findAllReversable(Long payId) {
		List<Balance> list=this.balanceRepository.findByPayId(payId);
		return this.findRerversable1(list);
	}
	@Override
	public List<Balance> findAllReversable(BalanceReceiver receiver) {
		return null;
//		List<Balance> list=this.balanceRepository.findAllReversable(receiver);
//		return this.findRerversable1(list);
	}
	@Override
	public List<Balance> findByPayIdResultAdv(Long B_PayID) {
		
		return this.balanceRepository.findByPayIdWithAdv(B_PayID);
	}


}
