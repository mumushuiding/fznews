package com.lt.cloud.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.tx.annotation.TxTransaction;
import com.google.gson.reflect.TypeToken;
import com.lt.cloud.feign.AdvFeignClient;
import com.lt.cloud.feign.BalanceFeignClient;
import com.lt.cloud.feign.OrderFeignClient;
import com.lt.cloud.pojo.Balance;
import com.lt.cloud.pojo.BalanceReceiver;
import com.lt.cloud.pojo.Payment;
import com.lt.cloud.pojo.adv.Advitem;
import com.lt.cloud.service.AdvService;
import com.lt.cloud.service.BalanceService;
import com.lt.cloud.service.OrderService;
import com.lt.cloud.service.PaymentService;
import com.lt.cloud.utils.JsonUtils;

import reactor.core.publisher.Mono;
@Component
public class BalanceServiceImpl implements BalanceService{
	@Autowired
	private BalanceFeignClient balanceFeignClient;
	@Autowired
	private AdvService advService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private PaymentService paymentService;
	@Override
	public Mono<String> findAll(String receiver) {
		
		return Mono.just(this.balanceFeignClient.findAll(receiver));
	}

	@Override
	@TxTransaction
	public Boolean saveAll(String json) {

		return this.balanceFeignClient.saveAll(json);
	}

	@Override
	@TxTransaction(isStart = true)
	public boolean balance(String json) {
		//添加平账
		Boolean resbalance=this.saveAll(json);
		List<Balance> balances=JsonUtils.getGson().fromJson(json, new TypeToken<List<Balance>>() {}.getType());
		List<Advitem> advitems=new ArrayList<>();
		
		balances.stream().forEach(balance->{
			Advitem advitem=new Advitem();
			advitem.setSYS_DOCUMENTID(balance.getB_AdItemID());
			advitem.setAI_OrderID(balance.getB_OrderID());
			advitem.setAI_BalancedMoney(balance.getB_Amount());
			advitem.setAI_AmountReceived(balance.getB_AmountReal()==null?0.0:balance.getB_AmountReal());
			advitem.setAI_InvoicedMoney(balance.getB_AmountInvoiced());
			advitem.setSYS_CURRENTUSERID(balance.getSYS_CURRENTUSERID());
			advitem.setSYS_CURRENTUSERNAME(balance.getSYS_CURRENTUSERNAME());
			advitems.add(advitem);
		});
		//以下所有相关变化只跟B_Amount有关
		String advitemList=JsonUtils.getGson().toJson(advitems);
		//更新广告
		Boolean advres=this.advService.updateAll(advitemList);
	//		更新订单
		Boolean orderres=this.orderService.updateAllWithAdvitem(advitemList);
		Payment payment=new Payment();
		balances.stream().map(e->e.getB_PayID()).distinct().forEach(id->{
			payment.setSYS_DOCUMENTiD(id);
			payment.setPbalancedmoney(balances.stream().map(b -> b.getB_Amount()).reduce((a, b) -> a + b).get());
			payment.setPbalancedreal(balances.stream().map(b -> b.getB_AmountReal()).reduce((a, b) -> a + b).get());
		});
		//更新收款
		Boolean paymentres=this.paymentService.save(JsonUtils.getGson().toJson(payment));
		return resbalance&&advres&&orderres&&paymentres;
	}

	@Override
	public Mono<String> findAllReversable(Long payId) {
		
		return Mono.just(this.balanceFeignClient.findAllReversable(payId));
	}

	@Override
	public String findByPayIdResultAdv(Long payId) {
		
		return this.balanceFeignClient.findByPayIdResultAdv(payId);
	}

}
