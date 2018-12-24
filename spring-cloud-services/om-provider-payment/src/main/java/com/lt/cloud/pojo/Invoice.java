package com.lt.cloud.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="invoice")
public class Invoice {
	   
	  @Id
      private  long SYS_DOCUMENTID;
      @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
      private  Date SYS_CREATED;
      @DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
      private  Date SYS_LASTMODIFIED;
     
      private String SYS_CURRENTSTATUS;
      
      private  long SYS_CURRENTUSERID;
     
	
      private  String SYS_CURRENTUSERNAME;




     
      @Column(name="i_invoicecode")
      private  String I_InvoiceCode;//发票代码
     
	@Column(name="i_invoiceno")
      private  String invoiceno;//发票号
     
	 //0
      private  long I_Type;//发票类型
     
	 //0
      private  long I_Customer_ID;
     
      @Column(name="I_customer")
      private  String customer;
     
	
      private  String I_Receiver;//发票抬头
     
	 //0.00
      private  double I_Amount;//开票金额，借票金额
     
	 @Column(name="i_amountback")
      private  double I_AmountBack;//回款金额
     
	 @Column(name="i_amountlinked")
      private  double IAmountLinked;//已关联金额
     
	 @Column(name="i_amountunlinked")
      private  double IAmountUnLinked;//未关联金额
     

     
	
      private  Date I_Date;//开票日期
     
	 //0
      private  long I_OperatorID;

	
      private  String I_Memo;


	public long getSYS_DOCUMENTID() {
		return SYS_DOCUMENTID;
	}


	public void setSYS_DOCUMENTID(long sYS_DOCUMENTID) {
		SYS_DOCUMENTID = sYS_DOCUMENTID;
	}


	public Date getSYS_CREATED() {
		return SYS_CREATED;
	}


	public void setSYS_CREATED(Date sYS_CREATED) {
		SYS_CREATED = sYS_CREATED;
	}


	public Date getSYS_LASTMODIFIED() {
		return SYS_LASTMODIFIED;
	}


	public void setSYS_LASTMODIFIED(Date sYS_LASTMODIFIED) {
		SYS_LASTMODIFIED = sYS_LASTMODIFIED;
	}


	public String getSYS_CURRENTSTATUS() {
		return SYS_CURRENTSTATUS;
	}


	public void setSYS_CURRENTSTATUS(String sYS_CURRENTSTATUS) {
		SYS_CURRENTSTATUS = sYS_CURRENTSTATUS;
	}


	public long getSYS_CURRENTUSERID() {
		return SYS_CURRENTUSERID;
	}


	public void setSYS_CURRENTUSERID(long sYS_CURRENTUSERID) {
		SYS_CURRENTUSERID = sYS_CURRENTUSERID;
	}


	public String getSYS_CURRENTUSERNAME() {
		return SYS_CURRENTUSERNAME;
	}


	public void setSYS_CURRENTUSERNAME(String sYS_CURRENTUSERNAME) {
		SYS_CURRENTUSERNAME = sYS_CURRENTUSERNAME;
	}




	public String getI_InvoiceCode() {
		return I_InvoiceCode;
	}


	public void setI_InvoiceCode(String i_InvoiceCode) {
		I_InvoiceCode = i_InvoiceCode;
	}


	public String getInvoiceno() {
		return invoiceno;
	}


	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}




	public long getI_Type() {
		return I_Type;
	}


	public void setI_Type(long i_Type) {
		I_Type = i_Type;
	}


	public long getI_Customer_ID() {
		return I_Customer_ID;
	}


	public void setI_Customer_ID(long i_Customer_ID) {
		I_Customer_ID = i_Customer_ID;
	}


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}


	public String getI_Receiver() {
		return I_Receiver;
	}


	public void setI_Receiver(String i_Receiver) {
		I_Receiver = i_Receiver;
	}


	public double getI_Amount() {
		return I_Amount;
	}


	public void setI_Amount(double i_Amount) {
		I_Amount = i_Amount;
	}


	public double getI_AmountBack() {
		return I_AmountBack;
	}


	public void setI_AmountBack(double i_AmountBack) {
		I_AmountBack = i_AmountBack;
	}


	public double getIAmountLinked() {
		return IAmountLinked;
	}


	public void setIAmountLinked(double iAmountLinked) {
		IAmountLinked = iAmountLinked;
	}


	public double getIAmountUnLinked() {
		return IAmountUnLinked;
	}


	public void setIAmountUnLinked(double iAmountUnLinked) {
		IAmountUnLinked = iAmountUnLinked;
	}


	public Date getI_Date() {
		return I_Date;
	}


	public void setI_Date(Date i_Date) {
		I_Date = i_Date;
	}


	public long getI_OperatorID() {
		return I_OperatorID;
	}


	public void setI_OperatorID(long i_OperatorID) {
		I_OperatorID = i_OperatorID;
	}


	public String getI_Memo() {
		return I_Memo;
	}


	public void setI_Memo(String i_Memo) {
		I_Memo = i_Memo;
	}


	
     
}
