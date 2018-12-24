package com.lt.cloud.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codingapi.tx.annotation.TxTransaction;
import com.google.gson.reflect.TypeToken;
import com.lt.cloud.feign.PaymentFeignClient;
import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.Invoice;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.PaymentReceive;
import com.lt.cloud.pojo.PaymentWrapper;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.service.AdvService;
import com.lt.cloud.service.BalanceService;
import com.lt.cloud.service.OrderService;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;
@Component
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymentFeignClient paymentFeignClient;
	@Autowired
	private AdvService advService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private BalanceService balanceService;
	@Override
	public String selectAllPayment(HashMap<String, Object> params) {
		
		return this.paymentFeignClient.selectAllPayment(params);
	}
	@Override
	public String findAllCollectionMode() {
		
		return this.paymentFeignClient.findAllCollectionMode();
	}
	/**
	 * 所有关于金额的更新都是：最终金额=旧的金额+新的金额
	 */
	@Override
	@TxTransaction
	public Boolean save(String payment) {

		return this.paymentFeignClient.save(payment);
	}
	@Override
	@TxTransaction(isStart=true)
	public void moneyback(String json) {
		PaymentWrapper wrapper=JsonUtils.getGson().fromJson(json, PaymentWrapper.class);
		//新建借票回款
		this.save(JsonUtils.getGson().toJson(wrapper.getNewpayment()));
		//更新旧的收款
		wrapper.getNewpayment().setP_SrcID(null);//P_SrcID只有借票回款才不为空
			//新的收款SYS_DOCUMENTiD为空，无法对旧的收款进行更新，所以要赋予其旧收款的ID
		wrapper.getNewpayment().setSYS_DOCUMENTiD(wrapper.getOldpayment().getSYS_DOCUMENTiD());
		this.save(JsonUtils.getGson().toJson(wrapper.getNewpayment()));

		
	}
	/**
	 * 更新收款并实平帐
	 */
	@Override
	@TxTransaction(isStart=true)
	public void updateAndBalanceReal(String json) {
		//根据收款号从平帐表查询出所有广告的ID和平帐金额，并设置广告的收款金额为平帐金额
		Payment payment=JsonUtils.getGson().fromJson(json, Payment.class);
		List<Balance> balances=JsonUtils.getGson().fromJson(this.balanceService.findByPayIdResultAdv(payment.getSYS_DOCUMENTiD()),
				new TypeToken<List<Balance>>(){}.getType());
		List<Advitem> advitems=new ArrayList<>();
		//这里默认收款金额为每个广告的平帐金额，如果已经平帐过了，结果会自动修正，没有影响
		balances.forEach(balance->{
			Advitem advitem=new Advitem();
			advitem.setSYS_DOCUMENTID(balance.getB_AdItemID());
			advitem.setAI_OrderID(balance.getB_OrderID());
			advitem.setAI_AmountReceived(balance.getB_Amount());
			advitems.add(advitem);
		});
		String advitemList=JsonUtils.getGson().toJson(advitems);
		try {
			//广告更新收款金额
			Boolean advres=this.advService.updateAll(advitemList);
			//订单更新收款金额
			Boolean orderres=this.orderService.updateAllWithAdvitem(advitemList);
			//更新收款
			boolean resp=this.save(json);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	@Override
	public Payment findById(Long id) {
		
		return JsonUtils.getGson().fromJson(this.paymentFeignClient.findById(id), Payment.class);
	}
	@Override
	public String findAll(String receive) {
		
		return this.paymentFeignClient.findAll(receive);
	}
	@Override
	public Boolean update(String json) {
		
		return this.paymentFeignClient.update(json);
	}
	@Override
	@TxTransaction
	public Boolean updateInvoice(String invoice) {
		
		return this.paymentFeignClient.updateInvoice(invoice);
	}
	@Override
	@TxTransaction
	public Boolean deleteInvoice(String invoice) {
		
		return this.paymentFeignClient.deleteInvoice(invoice);
	}
	@Override
	public void deleteById(Long id) {
		this.paymentFeignClient.deleteById(id);
		
	}



}
