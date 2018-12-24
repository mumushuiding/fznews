package com.lt.cloud.service.impl;

import java.util.ArrayList;
import java.util.List;

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

import com.lt.cloud.dao.jpa.IncomeAdjustRepository;
import com.lt.cloud.pojo.Incomeadjust;
import com.lt.cloud.pojo.IncomeajustReceiver;
import com.lt.cloud.service.IncomeAdjustService;

@Component
public class IncomeAdjustServiceImpl implements IncomeAdjustService{
	@Autowired
	private IncomeAdjustRepository incomeAdjustRepository;
	@Override
	public Page<Incomeadjust> findAll(IncomeajustReceiver receiver) {
		Specification<Incomeadjust> specification=new Specification<Incomeadjust>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Incomeadjust> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates=new ArrayList<>();
				if (receiver.getAditemid()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("aditemid"),receiver.getAditemid()));
				}
				if (receiver.getOrderid()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("orderid"), receiver.getOrderid()));
				}
				if (receiver.getSYS_CREATEDSTART()!=null) {
					predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("SYS_CREATEDSTART"), receiver.getSYS_CREATEDSTART()));
				}
				if (receiver.getSYS_CREATEDEND()!=null) {
					predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("SYS_CREATEDEND"), receiver.getSYS_CREATEDEND()));
				}
				List<Order> orders=new ArrayList<>();
				orders.add(criteriaBuilder.desc(root.get("SYS_LASTMODIFIED")));
				return query.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orders).getRestriction();
			}
		};
		return this.incomeAdjustRepository.findAll(specification, 
				PageRequest.of(receiver.getPageIndex()==null?0:(receiver.getPageIndex()-1),
						receiver.getPageSize()==null?15:receiver.getPageSize()));
	}

}
