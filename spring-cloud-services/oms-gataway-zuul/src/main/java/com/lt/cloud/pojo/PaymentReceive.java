package com.lt.cloud.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class PaymentReceive {
	private String pCustomer;//客户
	private String sYSCURRENTUSERNAME;//操作员
	private String pSalesman;//业务员
	private Long pOrderID;//订单号
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date  pDateStart;//	收款日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pDateEnd;//	收款日期
	private String pInvoiceNo;//发票号
	private Boolean isBalance;
	private Boolean isInvoice;
	private Integer pageIndex;
	private Integer pageSize;
	
	public Boolean getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(Boolean isInvoice) {
		this.isInvoice = isInvoice;
	}
	public Boolean getIsBalance() {
		return isBalance;
	}
	public void setIsBalance(Boolean isBalance) {
		this.isBalance = isBalance;
	}
	public Date getpDateStart() {
		return pDateStart;
	}
	public void setpDateStart(Date pDateStart) {
		this.pDateStart = pDateStart;
	}
	public Date getpDateEnd() {
		return pDateEnd;
	}
	public void setpDateEnd(Date pDateEnd) {
		this.pDateEnd = pDateEnd;
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
	public String getpCustomer() {
		return pCustomer;
	}
	public void setpCustomer(String pCustomer) {
		this.pCustomer = pCustomer;
	}
	public String getsYSCURRENTUSERNAME() {
		return sYSCURRENTUSERNAME;
	}
	public void setsYSCURRENTUSERNAME(String sYSCURRENTUSERNAME) {
		this.sYSCURRENTUSERNAME = sYSCURRENTUSERNAME;
	}
	public String getpSalesman() {
		return pSalesman;
	}
	public void setpSalesman(String pSalesman) {
		this.pSalesman = pSalesman;
	}
	public Long getpOrderID() {
		return pOrderID;
	}
	public void setpOrderID(Long pOrderID) {
		this.pOrderID = pOrderID;
	}
	

	public String getpInvoiceNo() {
		return pInvoiceNo;
	}
	public void setpInvoiceNo(String pInvoiceNo) {
		this.pInvoiceNo = pInvoiceNo;
	}
	
	
}
