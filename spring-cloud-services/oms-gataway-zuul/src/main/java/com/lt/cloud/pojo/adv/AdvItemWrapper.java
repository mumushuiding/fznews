package com.lt.cloud.pojo.adv;

import java.util.List;

public class AdvItemWrapper {
	public List<Advitem> advitems;
	
	public Long AI_OrderID;
	
	

	public Long getAI_OrderID() {
		return AI_OrderID;
	}

	public void setAI_OrderID(Long aI_OrderID) {
		AI_OrderID = aI_OrderID;
	}

	public List<Advitem> getAdvitems() {
		return advitems;
	}

	public void setAdvitems(List<Advitem> advitems) {
		this.advitems = advitems;
	}
	
}
