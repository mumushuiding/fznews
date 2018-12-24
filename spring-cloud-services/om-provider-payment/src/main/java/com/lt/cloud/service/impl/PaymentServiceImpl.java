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
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.codingapi.tx.annotation.TxTransaction;
import com.lt.cloud.dao.jpa.PaymnetRepository;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;


@Component
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymnetRepository paymnetRepository;
	@Override
	public Page<Payment> findAll(PaymentReceive paymentReceive, Pageable pageable) {
		
		Specification<PaymentReceive> spec=new Specification<PaymentReceive>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<PaymentReceive> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicate=new ArrayList<>();
				if(paymentReceive.getSYS_DOCUMENTiD()!=null) {
					predicate.add(criteriaBuilder.equal(root.get("SYS_DOCUMENTiD"),paymentReceive.getSYS_DOCUMENTiD()));
				}
				if(!StringUtils.isEmpty(paymentReceive.getpCustomer())) {
					predicate.add(criteriaBuilder.like(root.get("pCustomer"), "%"+paymentReceive.getpCustomer()+"%"));
				}
				if(!StringUtils.isEmpty(paymentReceive.getSYS_AUTHORS())) {
					predicate.add(criteriaBuilder.equal(root.get("SYS_AUTHORS"), paymentReceive.getSYS_AUTHORS()));
				}
				if(!StringUtils.isEmpty(paymentReceive.getpInvoiceNo())) {
					predicate.add(criteriaBuilder.like(root.get("pInvoiceNo"), "%"+paymentReceive.getpInvoiceNo()+"%"));
				}
				if(!StringUtils.isEmpty(paymentReceive.getpSalesman())) {
					predicate.add(criteriaBuilder.like(root.get("pSalesman"), "%"+paymentReceive.getpSalesman()+"%"));
				}
				if (paymentReceive.getEndDate()!=null) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("SYS_CREaTED"),paymentReceive.getEndDate()));
				}
				if (paymentReceive.getStartDate()!=null) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("SYS_CREaTED"),paymentReceive.getStartDate()));
				}
				if(paymentReceive.getpDateStart()!=null) {
					predicate.add(criteriaBuilder.greaterThanOrEqualTo(root.get("pDate"),paymentReceive.getpDateStart()));
				}
				if(paymentReceive.getpDateEnd()!=null) {
					predicate.add(criteriaBuilder.lessThanOrEqualTo(root.get("pDate"), paymentReceive.getpDateEnd()));
				}
				if (paymentReceive.getpOrderID()!=null) {
					predicate.add(criteriaBuilder.like(root.get("pOrderID"), "%"+paymentReceive.getpOrderID()+"%"));
				}
				if(paymentReceive.getIsBalance()!=null && paymentReceive.getIsBalance()==true) {
					predicate.add(criteriaBuilder.greaterThan(root.get("pbalanceablemoney"), 0));
				}
				if (paymentReceive.getIsInvoice()!=null && paymentReceive.getIsInvoice()==true) {
					predicate.add(criteriaBuilder.greaterThan(root.get("pinvoiceablemoney"), 0));
				}
				Predicate[] pre=new Predicate[predicate.size()];
				List<Order> orders=new ArrayList<>();
				orders.add(criteriaBuilder.desc(root.get("SYS_LASTMODIFIED")));
				return query.where(predicate.toArray(pre)).orderBy(orders).getRestriction();
			}
		};
		
		return this.paymnetRepository.findAll(spec, pageable);
	}
	private Payment setMoneyback(Payment payment) {
		payment.setPinvoicedmoney(payment.getP_amount());
		payment.setP_Type(4);
		return payment;
	}
	private Payment normalpayment(Payment payment) {
		payment.setAmountleft(payment.getP_amount());
		payment.setPbalanceablemoney(payment.getP_amount());
		payment.setPinvoiceablemoney(payment.getP_amount());
		return payment;
	}
	private Payment lendpayment(Payment payment) {
		payment.setPbalanceablemoney(payment.getPinvoicedmoney());
		return payment;
	}
	@Override
	@TxTransaction
	@Transactional
	public void save(String json) {
		Payment payment=JsonUtils.getGson().fromJson(json, Payment.class);
		if(payment.getSYS_DOCUMENTiD()==null) {
			payment.setSYS_CREaTED(new Date());
			payment.setSYS_LASTMODIFIED(new Date());
			if (payment.getP_amount()==null || payment.getP_amount()==0) {
				//收款额为0，说明是借票收款，可平帐金额等于借票金额
				lendpayment(payment);
			}else {
				
				if (payment.getP_SrcID()!=null) {
					//为借票回款
					setMoneyback(payment);
				}else {
					//为正常收款，可平帐金额等于收款总额
					normalpayment(payment);
				}
				
			}
			try {
				this.save(payment);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}else {
			Payment old=this.findById(payment.getSYS_DOCUMENTiD());
			old.setSYS_LASTMODIFIED(new Date());
			if (payment.getP_amount()==null || payment.getP_amount()==0) {
				//收款额为0，说明是借票收款

			}else {
				//收款额不为0，说明是正常收款
				if (old.getP_amount()==null) old.setP_amount(0.0);
				old.setP_amount(old.getP_amount()+payment.getP_amount());
				if(old.getAmountleft()==null) old.setAmountleft(0.0);
				old.setAmountleft(payment.getP_amount()+old.getAmountleft());
			}
			//增加平帐金额
			if (payment.getPbalancedmoney()!=null) {
				if(old.getPbalancedmoney()==null) old.setPbalancedmoney(0.0);
				old.setPbalancedmoney(old.getPbalancedmoney()+payment.getPbalancedmoney());
				if(old.getPbalanceablemoney()==null) old.setPbalanceablemoney(0.0);
				old.setPbalanceablemoney(old.getPbalanceablemoney()-payment.getPbalancedmoney());
			}
			//修改实平帐金额
			if (payment.getPbalancedreal()!=null) {
				if(old.getPbalancedreal()==null) old.setPbalancedreal(0.0);
				old.setPbalancedreal(old.getPbalancedreal()+payment.getPbalancedreal());
				if(old.getPbalancedreal()<0)old.setPbalancedreal(0.0);//实平金额不能为负
				//修改剩余金额
				if (old.getP_amount()!=null&&(old.getP_amount()-old.getPbalancedreal()>0)) {
					old.setAmountleft(old.getP_amount()-old.getPbalancedreal());
				}else {
					old.setAmountleft(0.0);
				}
			}
			//修改关联发票金额
			if (payment.getPinvoicedmoney()!=null) {
				//如果开票金额不为0或者空
				if(old.getPinvoicedmoney()==null) old.setPinvoicedmoney(0.0);
				//更新已开票金额
				old.setPinvoicedmoney(old.getPinvoicedmoney()+payment.getPinvoicedmoney());
				if(old.getPinvoicedmoney()<0)old.setPinvoicedmoney(0.0);//已开票金额不能为负
				//更新可开票金额
				if(old.getPinvoiceablemoney()==null)old.setPinvoiceablemoney(0.0);
				old.setPinvoiceablemoney(old.getPinvoiceablemoney()-payment.getPinvoicedmoney());
				if(old.getPinvoiceablemoney()<0) old.setPinvoiceablemoney(0.0);//可开票金额不能为负
			}
			try {
				this.save(old);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
	}
	@Override
	public Payment save(Payment payment) {
		return this.paymnetRepository.save(payment);
	}
	@Override
	public Payment findById(Long id) {
		Optional<Payment> result = this.paymnetRepository.findById(id);
		if(result.isPresent()) return result.get();
		return null;
	}
	@Override
	public Boolean update(String json) {
		Payment np=JsonUtils.getGson().fromJson(json, Payment.class);
		Payment payment=this.findById(np.getSYS_DOCUMENTiD());
		if(payment==null) return false;
		payment.setSYS_LASTMODIFIED(new Date());
		payment.setSYS_CURRENTUSERID(np.getSYS_CURRENTUSERID());
		payment.setsYSCURRENTUSERNAME(np.getsYSCURRENTUSERNAME());
		
		//修改开票金额
		if (np.getPinvoicedmoney()!=null) {
			payment.setPinvoicedmoney(payment.getPinvoicedmoney()+np.getPinvoicedmoney());
			payment.setPinvoiceablemoney(payment.getP_amount()-payment.getPinvoicedmoney());
		}
		//修改平帐金额
		if (np.getPbalancedmoney()!=null) {
			payment.setPbalancedmoney(payment.getPbalancedmoney()+np.getPbalancedmoney());
			payment.setPbalanceablemoney(payment.getP_amount()-payment.getPbalancedmoney());
		}
		try {
			this.paymnetRepository.save(payment);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	@TxTransaction
	@Transactional
	public Boolean updateInvoice(String json) {
		System.out.println(json);
		Payment np=JsonUtils.getGson().fromJson(json, Payment.class);
		Payment payment=this.findById(np.getSYS_DOCUMENTiD());
		if(payment==null) return false;
		payment.setSYS_LASTMODIFIED(new Date());
		payment.setSYS_CURRENTUSERID(np.getSYS_CURRENTUSERID());
		payment.setsYSCURRENTUSERNAME(np.getsYSCURRENTUSERNAME());
		//借票回款修改
		if (np.getP_amount()!=null) {
			//回款涉及总额和剩余金额变化
			if(payment.getP_amount()==null) payment.setP_amount(0.0);
			if(payment.getAmountleft()==null) payment.setAmountleft(0.0);
			payment.setP_amount(payment.getP_amount()+np.getP_amount());
			payment.setAmountleft(payment.getAmountleft()+np.getPamountout());
		}
		//修改开票金额
		if (np.getPinvoicedmoney()!=null) {
			if(payment.getPinvoicedmoney()==null) payment.setPinvoicedmoney(0.0);
			//修改已经开票金额
			payment.setPinvoicedmoney(payment.getPinvoicedmoney()+np.getPinvoicedmoney());
			//修改可开票金额
			if (payment.getP_amount()-payment.getPinvoicedmoney()>0) {
				payment.setPinvoiceablemoney(payment.getP_amount()-payment.getPinvoicedmoney());
			}else {
				payment.setPinvoiceablemoney(0.0);
			}
			
			if(payment.getPinvoiceno()==null||"".equals(payment.getPinvoiceno())) {
				payment.setPinvoiceno(np.getPinvoiceno());
			}else {
				payment.setPinvoiceno(payment.getPinvoiceno()+","+np.getPinvoiceno());
			}
			
		}
		//修改平帐金额
		if (np.getPbalancedmoney()!=null) {
			if(payment.getPbalancedmoney()==null) payment.setPbalancedmoney(0.0);
			payment.setPbalancedmoney(payment.getPbalancedmoney()+np.getPbalancedmoney());
			if (payment.getP_amount()-payment.getPbalancedmoney()>0) {
				payment.setPbalanceablemoney(payment.getP_amount()-payment.getPbalancedmoney());
			}else {
				payment.setPbalanceablemoney(0.0);
			}
		}
		//修改实平帐金额
		if (np.getPbalancedreal()!=null) {
			if(payment.getPbalancedreal()==null) payment.setPbalancedreal(0.0);
			payment.setPbalancedreal(payment.getPbalancedreal()+np.getPbalancedreal());
		}
		try {
			this.paymnetRepository.save(payment);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	@TxTransaction
	@Transactional
	public void deleteInvoice(String json) {
		System.out.println(json);
		Payment newpayment=JsonUtils.getGson().fromJson(json, Payment.class);
		List<Payment> payments=this.paymnetRepository.findByPinvoicenoContaining(newpayment.getPinvoiceno());
		if (payments.size()==0) {
			return;
		}
		Payment oldPayment=this.paymnetRepository.findByPinvoicenoContaining(newpayment.getPinvoiceno()).get(0);
		//删除发票号
		oldPayment.setPinvoiceno(deleteInvoiceno(oldPayment.getPinvoiceno(), newpayment.getPinvoiceno()));
		//修改已开发票金额和未开发票金额
		oldPayment.setPinvoicedmoney(oldPayment.getPinvoicedmoney()-newpayment.getPinvoicedmoney());
		oldPayment.setPinvoiceablemoney(oldPayment.getP_amount()-oldPayment.getPinvoicedmoney());
		
		oldPayment.setSYS_CURRENTUSERID(newpayment.getSYS_CURRENTUSERID());
		oldPayment.setsYSCURRENTUSERNAME(newpayment.getsYSCURRENTUSERNAME());
		oldPayment.setSYS_LASTMODIFIED(new Date());
		if (oldPayment.getPinvoiceablemoney()!=0) {
			this.paymnetRepository.save(oldPayment);
		}else {
			this.paymnetRepository.deleteById(oldPayment.getSYS_DOCUMENTiD());
		}
		
	}

	private String deleteInvoiceno(String old,String target) {
		if (old.indexOf(",")>-1) {
			if (old.indexOf(target)==0) {
				old=old.replace(target+",", "");
			}else {
				old=old.replace(","+target, "");
			}
		}else {
			old=old.replace(target, "");
		}
		return old;
	}
	@Override
	public void deleteById(Long id) {
		this.paymnetRepository.deleteById(id);
		
	}


}
