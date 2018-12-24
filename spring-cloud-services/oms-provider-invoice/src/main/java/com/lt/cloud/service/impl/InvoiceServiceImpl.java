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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.codingapi.tx.annotation.TxTransaction;
import com.lt.cloud.dao.jpa.InvoiceRepository;
import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.InvoiceReceiver;
import com.lt.cloud.service.InvoiceService;
import com.lt.cloud.utils.JsonUtils;
@Component
public class InvoiceServiceImpl implements InvoiceService{
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Override
	public Page<Invoice> findAll(InvoiceReceiver invoiceReceiver) {
		Specification<Invoice> specification=new Specification<Invoice>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates=new ArrayList<>();
				if(invoiceReceiver.getType()!=null) {
					predicates.add(criteriaBuilder.equal(root.get("type"), invoiceReceiver.getType()));
				}
				if (!StringUtils.isEmpty(invoiceReceiver.getCustomer())) {
					predicates.add(criteriaBuilder.like(root.get("customer"), "%"+invoiceReceiver.getCustomer()+"%"));
				}
				if(!StringUtils.isEmpty(invoiceReceiver.getInvoiceno())) {
					predicates.add(criteriaBuilder.like(root.get("invoiceno"), "%"+invoiceReceiver.getInvoiceno()+"%"));
				}
				List<Order> orders=new ArrayList<>();
				orders.add(criteriaBuilder.desc(root.get("I_Date")));
 				return query.where(predicates.toArray(new Predicate[predicates.size()])).orderBy(orders).getRestriction();
			}
		};
		return this.invoiceRepository.findAll(specification, 
				PageRequest.of(invoiceReceiver.getPageIndex()==null?0:(invoiceReceiver.getPageIndex()-1),
						invoiceReceiver.getPageSize()==null?15:invoiceReceiver.getPageSize()));
	}
	@Override
	@TxTransaction
	@Transactional
	public Invoice save(Invoice invoice) {
		invoice.setSYS_LASTMODIFIED(new Date());
		if(invoice.getSYS_CREATED()==null) invoice.setSYS_CREATED(new Date());
		//关联金额IAmountLinked同回款金额I_AmountBack相关
		invoice.setIAmountLinked(invoice.getI_AmountBack()==null?0.0:invoice.getI_AmountBack());
		invoice.setIAmountUnLinked(invoice.getI_Amount()-invoice.getIAmountLinked());
		return this.invoiceRepository.save(invoice);
	}
	@Override
	@TxTransaction
	@Transactional
	public void update(String json) {
		Invoice invoice=JsonUtils.getGson().fromJson(json, Invoice.class);
		Invoice old=this.findById(invoice.getSYS_DOCUMENTID());
		if(old==null) throw new RuntimeException("ID为【"+invoice.getSYS_DOCUMENTID()+"】的发票已经删除");
		old.setSYS_LASTMODIFIED(new Date());
		old.setSYS_CURRENTUSERID(invoice.getSYS_CURRENTUSERID());
		old.setSYS_CURRENTUSERNAME(invoice.getSYS_CURRENTUSERNAME());
		//回款更新
		if(invoice.getI_AmountBack()!=null) {
			old.setI_AmountBack(old.getI_AmountBack()+invoice.getI_AmountBack());
			//已经关联金额的开票金额
			old.setIAmountLinked(old.getI_Amount());
			old.setIAmountUnLinked(old.getI_Amount()-old.getIAmountLinked());
		}
		
	}
	@Override
	public Invoice test(Invoice invoice) {
		
		return invoice;
	}
	@Override
	@TxTransaction
	@Transactional
	public void deleteById(Long id) {
		
		this.invoiceRepository.deleteById(id);
		
	}
	@Override
	public Invoice findById(Long id) {
		Optional<Invoice> invoice = this.invoiceRepository.findById(id);
		return invoice.isPresent()?invoice.get():null;
	}


}
