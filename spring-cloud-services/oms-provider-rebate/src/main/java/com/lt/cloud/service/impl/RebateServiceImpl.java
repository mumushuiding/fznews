package com.lt.cloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.lt.cloud.dao.jpa.RebateRepository;
import com.lt.cloud.pojo.Rebate;
import com.lt.cloud.pojo.RebateReceive;
import com.lt.cloud.service.RebateService;
import com.lt.cloud.utils.JsonUtils;
@Component
public class RebateServiceImpl implements RebateService{
	@Autowired
	private RebateRepository rebateRepository;

	@Override
	public Page<Rebate> findAll(RebateReceive receive,Pageable pageable) {
		
	   Specification<RebateReceive> spec=new Specification<RebateReceive>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Predicate toPredicate(Root<RebateReceive> root, CriteriaQuery<?> query,
				CriteriaBuilder criteriaBuilder) {
			List<Predicate> predicate=new ArrayList<>();
			if(!StringUtils.isEmpty(receive.getCustomer())) {
				predicate.add(criteriaBuilder.like(root.get("customer"), "%" + receive.getCustomer() + "%"));
			}
			if(receive.getStart()!=null) {
				predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("rDate"), receive.getStart()));
			}
			if(receive.getEnd()!=null) {
				predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("rDate"), receive.getEnd()));
			}
			Predicate[] pre = new Predicate[predicate.size()];
			List<Order> orders=new ArrayList<>();
			orders.add(criteriaBuilder.desc(root.get("rDate")));
			return query.where(predicate.toArray(pre)).orderBy(orders).getRestriction();
			
		}
	};

	   
		return this.rebateRepository.findAll(spec, pageable);
	}

	@Override
	public Page<Rebate> findAllRebate(RebateReceive rebateReceive, Pageable pageable) {
		
		return this.rebateRepository.findAllRebate(rebateReceive.getCustomer(), rebateReceive.getStart(), rebateReceive.getEnd(),pageable);
	}
	@Override
	public Boolean save(String json) {
		Rebate rebate=JsonUtils.getGson().fromJson(json, Rebate.class);
		if (rebate.getSYS_DOCUMENTID()==null) {
			rebate.setSYS_CREATED(new Date());
		}
		rebate.setSYS_LASTMODIFIED(new Date());
		try {
			this.rebateRepository.save(rebate);
		} catch (Exception e) {
			throw new RuntimeException("保存失败");
		}
		return true;	
	}












	
}
