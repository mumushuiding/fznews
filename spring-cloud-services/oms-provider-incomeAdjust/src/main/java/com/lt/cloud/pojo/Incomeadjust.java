package com.lt.cloud.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Incomeadjust {
	@Id
    private  long SYS_DOCUMENTID;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private  Date SYS_CREATED;//调整 
   
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private  Date SYS_LASTMODIFIED;

    private  long SYS_CURRENTUSERID;
   
	
    private  String SYS_CURRENTUSERNAME;
   
	
    private  String SYS_AUTHORS;
    @Column(name="ia_orderid")
    private  long orderid;//订单号
   
	 @Column(name="ia_aditemid")
    private  long aditemid;//广告号
   
	 //0.00
    private  double IA_Amount;
   
	 //0
    private  long IA_OperatorID;
   
	
    private  String IA_Memo;


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


	public String getSYS_AUTHORS() {
		return SYS_AUTHORS;
	}


	public void setSYS_AUTHORS(String sYS_AUTHORS) {
		SYS_AUTHORS = sYS_AUTHORS;
	}


	public long getOrderid() {
		return orderid;
	}


	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}


	public long getAditemid() {
		return aditemid;
	}


	public void setAditemid(long aditemid) {
		this.aditemid = aditemid;
	}


	public double getIA_Amount() {
		return IA_Amount;
	}


	public void setIA_Amount(double iA_Amount) {
		IA_Amount = iA_Amount;
	}


	public long getIA_OperatorID() {
		return IA_OperatorID;
	}


	public void setIA_OperatorID(long iA_OperatorID) {
		IA_OperatorID = iA_OperatorID;
	}


	public String getIA_Memo() {
		return IA_Memo;
	}


	public void setIA_Memo(String iA_Memo) {
		IA_Memo = iA_Memo;
	}


    

}
