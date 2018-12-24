package com.lt.cloud.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AdvitemReceiver {
	private Long SYS_DOCUMENTID;
	private String AI_Customer;
	private String AI_Salesman;
	private Long AI_Customer_ID;
	private Long AI_OrderID;
	private Boolean isBalance;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date AI_PublishTimeStart;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date AI_PublishTimeEnd;
	private String SYS_AUTHORS;
	private Integer pageIndex;
	private Integer pageSize;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSYS_AUTHORS() {
		return SYS_AUTHORS;
	}
	public void setSYS_AUTHORS(String sYS_AUTHORS) {
		SYS_AUTHORS = sYS_AUTHORS;
	}
	public String getAI_Salesman() {
		return AI_Salesman;
	}
	public void setAI_Salesman(String aI_Salesman) {
		AI_Salesman = aI_Salesman;
	}
	public Long getSYS_DOCUMENTID() {
		return SYS_DOCUMENTID;
	}
	public void setSYS_DOCUMENTID(Long sYS_DOCUMENTID) {
		SYS_DOCUMENTID = sYS_DOCUMENTID;
	}
	public Long getAI_Customer_ID() {
		return AI_Customer_ID;
	}
	public void setAI_Customer_ID(Long aI_Customer_ID) {
		AI_Customer_ID = aI_Customer_ID;
	}
	public Boolean getIsBalance() {
		return isBalance;
	}
	public void setIsBalance(Boolean isBalance) {
		this.isBalance = isBalance;
	}
	public Long getAI_OrderID() {
		return AI_OrderID;
	}
	public void setAI_OrderID(Long aI_OrderID) {
		AI_OrderID = aI_OrderID;
	}
	public String getAI_Customer() {
		return AI_Customer;
	}
	public void setAI_Customer(String aI_Customer) {
		AI_Customer = aI_Customer;
	}
	public Date getAI_PublishTimeStart() {
		return AI_PublishTimeStart;
	}
	public void setAI_PublishTimeStart(Date aI_PublishTimeStart) {
		AI_PublishTimeStart = aI_PublishTimeStart;
	}
	public Date getAI_PublishTimeEnd() {
		return AI_PublishTimeEnd;
	}
	public void setAI_PublishTimeEnd(Date aI_PublishTimeEnd) {
		AI_PublishTimeEnd = aI_PublishTimeEnd;
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
