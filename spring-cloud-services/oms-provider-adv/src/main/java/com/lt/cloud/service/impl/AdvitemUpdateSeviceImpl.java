package com.lt.cloud.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codingapi.tx.annotation.TxTransaction;
import com.codingapi.tx.datasource.aspect.DataSourceAspect;
import com.codingapi.tx.springcloud.interceptor.TransactionAspect;
import com.lt.cloud.config.Settings;
import com.lt.cloud.dao.jpa.AdvitemRepository;
import com.lt.cloud.mapper.AdvitemMapper;
import com.lt.cloud.pojo.Advitem;
import com.lt.cloud.service.AdvitemUpdateSevice;
import com.lt.cloud.utils.JsonUtils;
@Component

public class AdvitemUpdateSeviceImpl implements AdvitemUpdateSevice{

	@Autowired
	private AdvitemMapper advitemMapper;
	@Autowired
	private AdvitemRepository advitemRepository;
	@Override
	public Advitem insertAdvitem(Advitem advitem) {
		
		try {
			return this.advitemRepository.save(advitem);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Long insertAdvdoc(Advitem advitem) {
		
		try {
			return this.advitemMapper.insertAdvdoc(advitem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0l;
	}

	@Override
	@TxTransaction
	@Transactional
	public Long updateAdvitem(Advitem advitem) {
		
		return this.advitemMapper.updateAdvitem(advitem);
	}

	@Override
	public Long updateAdvdoc(Advitem advitem) {
		
		return this.advitemMapper.updateAdvdoc(advitem);
	}

	@Override
	@TxTransaction
	@Transactional
	public void deleteById(Long id) {
		this.advitemRepository.deleteById(id);
	}

	@Override
	@TxTransaction
	@Transactional
	public Boolean saveAll(List<Advitem> advitems) {
		advitems.stream().map(item->{
			item.setSYS_LASTMODIFIED(new Date());
			if(item.getSYS_DOCUMENTID()==null) {
				item.setSYS_CREATED(new Date());
				item.setAI_BalancedMoney(0.0);
				item.setAI_AmountReceived(0.0);
				item.setAI_InvoicedMoney(0.0);
				item.setAI_PayStatus(Settings.BALANCE_NONE);
				if(item.getAI_AmountReceivable()!=null) {//订单收入AI_AmountPaid只有在创建时等于AI_AmountReceivable，后面若是进行收入调整就不相同了
					item.setAI_AmountPaid(item.getAI_AmountReceivable());
				}
			}
			item.setAI_UnitPrice(item.getAI_Price());

			item.setAI_UnbalancedMoney(item.getAI_AmountReceivable()-item.getAI_BalancedMoney());
			item.setAI_UninvoicedMoney(item.getAI_AmountReceivable()-item.getAI_InvoicedMoney());
			item.setAI_Debt(item.getAI_AmountReceivable()-item.getAI_AmountReceived());
			return item;
		}).forEach(this.advitemRepository::save);
		return true;
	}

	@Override
	@TxTransaction
	@Transactional
	public void updateAll(List<Advitem> advitems) {
		try {
			advitems.stream().map(item->{
				System.out.println("***************id="+item.getSYS_DOCUMENTID());
				Advitem advitem= this.findById(item.getSYS_DOCUMENTID());
				if(advitem==null) return null;
				advitem.setSYS_LASTMODIFIED(new Date());
				advitem.setSYS_CURRENTUSERID(item.getSYS_CURRENTUSERID());
				advitem.setSYS_CURRENTUSERNAME(item.getSYS_CURRENTUSERNAME());
				//修改平帐金额
				if(item.getAI_BalancedMoney()!=null) {
					if(advitem.getAI_BalancedMoney()==null) advitem.setAI_BalancedMoney(0.0);
					advitem.setAI_BalancedMoney(advitem.getAI_BalancedMoney()+item.getAI_BalancedMoney());//平帐为平帐金额
					if(advitem.getAI_BalancedMoney()>0) {
						advitem.setAI_PayTime(new Date());
						if (advitem.getAI_BalancedMoney()<advitem.getAI_AmountReceivable()) {//平帐金额小于总额
							advitem.setAI_PayStatus(Settings.BALANCE_PART);
						}else {
							advitem.setAI_PayStatus(Settings.BALANCE_COMPLETE);
						}
					}
//					if(advitem.getAI_UnbalancedMoney()==null)advitem.setAI_UnbalancedMoney(0.0);
					advitem.setAI_UnbalancedMoney(advitem.getAI_AmountReceivable()-advitem.getAI_BalancedMoney());
				}
				//修改实平帐金额
				if(item.getAI_AmountReceived()!=null) {
					if(advitem.getAI_AmountReceived()==null) advitem.setAI_AmountReceived(0.0);
					advitem.setAI_AmountReceived(advitem.getAI_AmountReceived()+item.getAI_AmountReceived());//收款为【实】平帐金额
					//如果收款总额大于广告的总额，则自动修正总收款额等于广告总额
					if(advitem.getAI_AmountReceived()>advitem.getAI_AmountReceivable())advitem.setAI_AmountReceived(advitem.getAI_AmountReceivable());
					advitem.setAI_Debt(advitem.getAI_AmountReceivable()-advitem.getAI_AmountReceived());
				}
				//修改开票金额
				if (item.getAI_InvoicedMoney()!=null) {
					if(advitem.getAI_InvoicedMoney()==null) advitem.setAI_InvoicedMoney(0.0);
					advitem.setAI_InvoicedMoney(advitem.getAI_InvoicedMoney()+item.getAI_InvoicedMoney());
					advitem.setAI_UninvoicedMoney(advitem.getAI_UninvoicedMoney()-item.getAI_InvoicedMoney());
				}
				return advitem;
			}).forEach(ad->{
				if(ad!=null) this.advitemRepository.save(ad);
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	@Query
	@TxTransaction
	@Transactional
	public void deleteByOrderId(Long id) {
		advitemRepository.deleteByOrderId(id);
		
	}
@Override
public Advitem findById(Long id) {
	Optional<Advitem> advitem = this.advitemRepository.findById(id);
	return advitem.isPresent()?advitem.get():null;
}

}
