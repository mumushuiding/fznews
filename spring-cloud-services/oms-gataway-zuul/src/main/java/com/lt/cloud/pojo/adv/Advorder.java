package com.lt.cloud.pojo.adv;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
public class Advorder {

	private Long SYS_DOCUMENTID;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_CREATED;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_LASTMODIFIED;
	private Long SYS_CURRENTUSERID;
	private String SYS_CURRENTUSERNAME;
	private String SYS_AUTHORS;
	private Long AO_Customer_ID;
	private String AO_Customer;
	private Long AO_Agent_ID;
	private String AO_Agent;
	private Long AO_Advertiser_ID;
	private String AO_Advertiser;

	private int AO_Org_ID;
	private String AO_Org;
	private String AO_Salesman_ID;
	private String AO_Salesman;
	private int AO_AdCountIC;
	private double AO_AllMoney;
	private double AO_AmountPaid;
	private double AO_ReceivedMoney;
	private double AO_DebtMoney;
	private Long AO_OperatorID;
	private String AO_Memo;
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
	public String getSYS_AUTHORS() {
		return SYS_AUTHORS;
	}
	public void setSYS_AUTHORS(String sYS_AUTHORS) {
		SYS_AUTHORS = sYS_AUTHORS;
	}
	public Long getAO_Customer_ID() {
		return AO_Customer_ID;
	}
	public void setAO_Customer_ID(Long aO_Customer_ID) {
		AO_Customer_ID = aO_Customer_ID;
	}
	public String getAO_Customer() {
		return AO_Customer;
	}
	public void setAO_Customer(String aO_Customer) {
		AO_Customer = aO_Customer;
	}
	public Long getAO_Agent_ID() {
		return AO_Agent_ID;
	}
	public void setAO_Agent_ID(Long aO_Agent_ID) {
		AO_Agent_ID = aO_Agent_ID;
	}
	public String getAO_Agent() {
		return AO_Agent;
	}
	public void setAO_Agent(String aO_Agent) {
		AO_Agent = aO_Agent;
	}
	public Long getAO_Advertiser_ID() {
		return AO_Advertiser_ID;
	}
	public void setAO_Advertiser_ID(Long aO_Advertiser_ID) {
		AO_Advertiser_ID = aO_Advertiser_ID;
	}
	public String getAO_Advertiser() {
		return AO_Advertiser;
	}
	public void setAO_Advertiser(String aO_Advertiser) {
		AO_Advertiser = aO_Advertiser;
	}

	public int getAO_Org_ID() {
		return AO_Org_ID;
	}
	public void setAO_Org_ID(int aO_Org_ID) {
		AO_Org_ID = aO_Org_ID;
	}
	public String getAO_Org() {
		return AO_Org;
	}
	public void setAO_Org(String aO_Org) {
		AO_Org = aO_Org;
	}
	public String getAO_Salesman_ID() {
		return AO_Salesman_ID;
	}
	public void setAO_Salesman_ID(String aO_Salesman_ID) {
		AO_Salesman_ID = aO_Salesman_ID;
	}
	public String getAO_Salesman() {
		return AO_Salesman;
	}
	public void setAO_Salesman(String aO_Salesman) {
		AO_Salesman = aO_Salesman;
	}
	public int getAO_AdCountIC() {
		return AO_AdCountIC;
	}
	public void setAO_AdCountIC(int aO_AdCountIC) {
		AO_AdCountIC = aO_AdCountIC;
	}
	public double getAO_AllMoney() {
		return AO_AllMoney;
	}
	public void setAO_AllMoney(double aO_AllMoney) {
		AO_AllMoney = aO_AllMoney;
	}
	public double getAO_AmountPaid() {
		return AO_AmountPaid;
	}
	public void setAO_AmountPaid(double aO_AmountPaid) {
		AO_AmountPaid = aO_AmountPaid;
	}
	public double getAO_ReceivedMoney() {
		return AO_ReceivedMoney;
	}
	public void setAO_ReceivedMoney(double aO_ReceivedMoney) {
		AO_ReceivedMoney = aO_ReceivedMoney;
	}
	public double getAO_DebtMoney() {
		return AO_DebtMoney;
	}
	public void setAO_DebtMoney(double aO_DebtMoney) {
		AO_DebtMoney = aO_DebtMoney;
	}
	public Long getAO_OperatorID() {
		return AO_OperatorID;
	}
	public void setAO_OperatorID(Long aO_OperatorID) {
		AO_OperatorID = aO_OperatorID;
	}
	public String getAO_Memo() {
		return AO_Memo;
	}
	public void setAO_Memo(String aO_Memo) {
		AO_Memo = aO_Memo;
	}

	
}
