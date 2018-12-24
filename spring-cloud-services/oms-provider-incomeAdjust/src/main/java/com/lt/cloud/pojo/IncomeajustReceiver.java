package com.lt.cloud.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IncomeajustReceiver {
	private  Long orderid;//订单号
	private  Long aditemid;//广告号
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private  Date SYS_CREATEDSTART;//调整日期
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private  Date SYS_CREATEDEND;//调整日期
	private Integer pageIndex;
	private Integer pageSize;
	
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public Long getAditemid() {
		return aditemid;
	}
	public void setAditemid(Long aditemid) {
		this.aditemid = aditemid;
	}
	public Date getSYS_CREATEDSTART() {
		return SYS_CREATEDSTART;
	}
	public void setSYS_CREATEDSTART(Date sYS_CREATEDSTART) {
		SYS_CREATEDSTART = sYS_CREATEDSTART;
	}
	public Date getSYS_CREATEDEND() {
		return SYS_CREATEDEND;
	}
	public void setSYS_CREATEDEND(Date sYS_CREATEDEND) {
		SYS_CREATEDEND = sYS_CREATEDEND;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	

}
