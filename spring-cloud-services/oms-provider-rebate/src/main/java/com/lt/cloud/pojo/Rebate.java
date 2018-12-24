package com.lt.cloud.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="rebate")
public class Rebate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long SYS_DOCUMENTID;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date SYS_CREATED;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date SYS_LASTMODIFIED;
	
	private Long SYS_CURRENTUSERID;
	private String SYS_CURRENTUSERNAME;
	private String SYS_AUTHORS;
	private Long R_Customer_ID;
	@Column(name="R_Customer")
	private String customer;
	
	private Double R_Amount;//返款金额
	@Column(name="R_amountused")
	private Double R_AmountUsed;//已用金额
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name="R_Date")
	private Date rDate;//返款日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date R_ValidDateBegin;//开始有效期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date R_ValidDateEnd;//结束有效期
	
	private String R_Memo;//备注

	public String getSYS_AUTHORS() {
		return SYS_AUTHORS;
	}

	public void setSYS_AUTHORS(String sYS_AUTHORS) {
		SYS_AUTHORS = sYS_AUTHORS;
	}

	public Long getSYS_DOCUMENTID() {
		return SYS_DOCUMENTID;
	}

	public void setSYS_DOCUMENTID(Long sYS_DOCUMENTID) {
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

	public Long getSYS_CURRENTUSERID() {
		return SYS_CURRENTUSERID;
	}

	public void setSYS_CURRENTUSERID(Long sYS_CURRENTUSERID) {
		SYS_CURRENTUSERID = sYS_CURRENTUSERID;
	}

	public String getSYS_CURRENTUSERNAME() {
		return SYS_CURRENTUSERNAME;
	}

	public void setSYS_CURRENTUSERNAME(String sYS_CURRENTUSERNAME) {
		SYS_CURRENTUSERNAME = sYS_CURRENTUSERNAME;
	}

	public Long getR_Customer_ID() {
		return R_Customer_ID;
	}

	public void setR_Customer_ID(Long r_Customer_ID) {
		R_Customer_ID = r_Customer_ID;
	}

	

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Double getR_Amount() {
		return R_Amount;
	}

	public void setR_Amount(Double r_Amount) {
		R_Amount = r_Amount;
	}

	public Double getR_AmountUsed() {
		return R_AmountUsed;
	}

	public void setR_AmountUsed(Double r_AmountUsed) {
		R_AmountUsed = r_AmountUsed;
	}

	

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public Date getR_ValidDateBegin() {
		return R_ValidDateBegin;
	}

	public void setR_ValidDateBegin(Date r_ValidDateBegin) {
		R_ValidDateBegin = r_ValidDateBegin;
	}

	public Date getR_ValidDateEnd() {
		return R_ValidDateEnd;
	}

	public void setR_ValidDateEnd(Date r_ValidDateEnd) {
		R_ValidDateEnd = r_ValidDateEnd;
	}

	public String getR_Memo() {
		return R_Memo;
	}

	public void setR_Memo(String r_Memo) {
		R_Memo = r_Memo;
	}
	
	
	
	
	
	
}
