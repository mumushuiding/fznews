package com.lt.cloud.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.codingapi.tx.annotation.TxTransaction;
import com.codingapi.tx.datasource.aspect.DataSourceAspect;
import com.codingapi.tx.framework.utils.SocketManager;
import com.google.gson.reflect.TypeToken;
import com.lt.cloud.dao.jpa.AdvorderRepository;
import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.pojo.Advorder;
import com.lt.cloud.pojo.AdvorderReceiver;
import com.lt.cloud.service.OrderQueryService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;

@Component
public class OrderQueryServiceImpl implements OrderQueryService{
	 private Logger logger = LoggerFactory.getLogger(OrderQueryService.class);
	@Autowired
	private AdvorderRepository advorderRepository;

	@Override
	public Page<Advorder> findAll(AdvorderReceiver receiver) {
		Specification<Advorder> specification=new Specification<Advorder>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Advorder> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates=new ArrayList<>();
				if(!StringUtils.isEmpty(receiver.getAO_Customer())) {
					predicates.add(criteriaBuilder.like(root.get("AO_Customer"), "%"+receiver.getAO_Customer()+"%"));
				}
				if (receiver.getEndDate()!=null) {
					predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("SYS_CREATED"),receiver.getEndDate()));
				}
				if (receiver.getStartDate()!=null) {
					predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("SYS_CREATED"),receiver.getStartDate()));
				}
				if (receiver.getSYS_DOCUMENTID()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("SYS_DOCUMENTID"), receiver.getSYS_DOCUMENTID()));
				}
				if (!StringUtils.isEmpty(receiver.getAO_Salesman())) {
					predicates.add(criteriaBuilder.equal(root.get("AO_Salesman"), receiver.getAO_Salesman()));
				}
				if (!StringUtils.isEmpty(receiver.getSYS_AUTHORS())) {
					predicates.add(criteriaBuilder.equal(root.get("SYS_AUTHORS"), receiver.getSYS_AUTHORS()));
				}
				if (!StringUtils.isEmpty(receiver.getAO_Org())) {
					predicates.add(criteriaBuilder.equal(root.get("AO_Org"), receiver.getAO_Org()));
				}
				List<Order> orders=new ArrayList<>();
				orders.add(criteriaBuilder.desc(root.get("SYS_CREATED")));
				return query.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orders).getRestriction();
			}
		
		};
		return this.advorderRepository.findAll(specification,
				PageRequest.of(
						receiver.getPageIndex()==null?0:(receiver.getPageIndex()-1),
								receiver.getPageSize()==null?10:receiver.getPageSize()));
	}

	@Override
	public Advorder findById(Long id) {
		Optional<Advorder> result = this.advorderRepository.findById(id);
		return result.isPresent()?result.get():null;
	}

	@Override
	public Advorder save(Advorder advOrder) {
		
		return this.advorderRepository.save(advOrder);
	}

	@Override
	public Advorder update(Advorder advOrder) {
		
		return this.save(advOrder);
	}
	@Override
	@TxTransaction
    @Transactional
	public void updateAllWithAdvitem(String advitemList) {
		List<Advitem> list=JsonUtils.getGson().fromJson(advitemList,new TypeToken<List<Advitem>>() {}.getType());
		//先找出不同的OrderId
		list.stream().map(e->e.getAI_OrderID()).distinct().forEach(item2->{
			Advorder advorder=this.advorderRepository.findById(item2).get();
			advorder.setSYS_LASTMODIFIED(new Date());
			list.stream().filter(item -> {
				return advorder.getSYS_DOCUMENTID().equals(item.getAI_OrderID());
			}).forEach(item1 -> {
				//总额变化,同时总额增加债务也增加
				if(advorder.getAO_AllMoney()==null) advorder.setAO_AllMoney(0.0);
				if(advorder.getAO_DebtMoney()==null) advorder.setAO_DebtMoney(0.0);
				if(advorder.getAO_AmountPaid()==null) advorder.setAO_AmountPaid(0.0);
				if (item1.getAI_AmountReceivable()!=null) {
					advorder.setAO_AllMoney(advorder.getAO_AllMoney()+item1.getAI_AmountReceivable());
					advorder.setAO_AmountPaid(advorder.getAO_AmountPaid()+item1.getAI_AmountReceivable());
					advorder.setAO_DebtMoney(advorder.getAO_DebtMoney()+item1.getAI_AmountReceivable());
				}
				//已收款变化（或者实平帐金额变化）
				if(advorder.getAO_ReceivedMoney()==null) advorder.setAO_ReceivedMoney(0.0);
				if(advorder.getAO_DebtMoney()==null) advorder.setAO_DebtMoney(0.0);
				if(item1.getAI_AmountReceived()!=null && item1.getAI_AmountReceived()!=0) {
					advorder.setAO_ReceivedMoney(advorder.getAO_ReceivedMoney()+item1.getAI_AmountReceived());
					advorder.setAO_DebtMoney(advorder.getAO_DebtMoney()-item1.getAI_AmountReceived());
				}
				try {
					if (advorder.getAO_ReceivedMoney()>advorder.getAO_AllMoney()) {
						//如果收款总额大于订单总额，自动修正为订单总额
						advorder.setAO_ReceivedMoney(advorder.getAO_AllMoney());
						advorder.setAO_DebtMoney(0.0);
					}
					this.advorderRepository.save(advorder);
				} catch (Exception e2) {
					logger.debug("更新失败");
					e2.printStackTrace();
					throw new RuntimeException();
				}
				
			});
		}
		);
		
	}

	@Override
	@TxTransaction
	@Transactional
	public void deleteById(Long id) {
		this.advorderRepository.deleteById(id);
		
	}

	
	

}
