package com.lt.cloud.pojo;

import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

public class Payment {

	private Long SYS_DOCUMENTiD;

	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_CREaTED;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_LASTMODIFIED;
	private Long SYS_CURRENTUSERID;
	private String SYS_CURRENTSTATUS;
	private String sYSCURRENTUSERNAME;
	private Integer P_SrcID;
	private Long pOrderiD;
	private Long p_Customer_iD;

	private String pCustomer;
	private Long P_Salesman_iD;

	private String pSalesman;

	private int ppublicationiD;
	private String 	p_publication;

	private int ppayModeiD;

	private String ppaymode;
	private String SYS_AUTHORS;//收款人
	private Double p_amount;//收款金额

	private Double 	amountleft;//余款

	private Double pamountout;//	转出金额

	private Double pamountback;//退款金额

	private String pinvoiceno;//发票号

	private Double pinvoiceablemoney;//未开票金额

	private Double pinvoicedmoney;//已开票金额

	private Double pbalanceablemoney;//可平账金额

	private Double pbalancedmoney;//平账金额

	private Double pbalancedreal;//实平账金额
	private int p_Type;//收款类型
	@DateTimeFormat(pattern="yyyy-MM-dd")

	private Date pDate;//	收款日期
	
	private Long p_OperatoriD;//收款员

	private int phasleft;//是否有余款

	private int phasreceipt;//是否有发票

	private int phasout;//是否有转账

	private int phasback;//是否有退款

	private int pLocked;//是否锁定
	private String p_Memo;//备注
	private Long P_Org_ID;//部门
	private String P_Org;
	
	public Long getP_Org_ID() {
		return P_Org_ID;
	}
	public void setP_Org_ID(Long p_Org_ID) {
		P_Org_ID = p_Org_ID;
	}
	public String getP_Org() {
		return P_Org;
	}
	public void setP_Org(String p_Org) {
		P_Org = p_Org;
	}
	@Override
	public String toString() {
		return "Payment [SYS_DOCUMENTiD=" + SYS_DOCUMENTiD + ", SYS_CREaTED=" + SYS_CREaTED + ", SYS_LASTMODIFIED="
				+ SYS_LASTMODIFIED + ", SYS_CURRENTUSERID=" + SYS_CURRENTUSERID + ", sYSCURRENTUSERNAME="
				+ sYSCURRENTUSERNAME + ", pOrderiD=" + pOrderiD + ", p_Customer_iD=" + p_Customer_iD + ", pCustomer="
				+ pCustomer + ", P_Salesman_iD=" + P_Salesman_iD + ", pSalesman=" + pSalesman + ", ppublicationiD="
				+ ppublicationiD + ", p_publication=" + p_publication + ", ppayModeiD=" + ppayModeiD + ", ppaymode="
				+ ppaymode + ", SYS_AUTHORS=" + SYS_AUTHORS + ", p_amount=" + p_amount + ", amountleft=" + amountleft
				+ ", pamountout=" + pamountout + ", pamountback=" + pamountback + ", pinvoiceno=" + pinvoiceno
				+ ", pinvoiceablemoney=" + pinvoiceablemoney + ", pinvoicedmoney=" + pinvoicedmoney
				+ ", pbalanceablemoney=" + pbalanceablemoney + ", pbalancedmoney=" + pbalancedmoney + ", pbalancedreal="
				+ pbalancedreal + ", p_Type=" + p_Type + ", pDate=" + pDate + ", p_OperatoriD=" + p_OperatoriD
				+ ", phasleft=" + phasleft + ", phasreceipt=" + phasreceipt + ", phasout=" + phasout + ", phasback="
				+ phasback + ", pLocked=" + pLocked + ", p_Memo=" + p_Memo + "]";
	}
	public String getSYS_AUTHORS() {
		return SYS_AUTHORS;
	}
	public void setSYS_AUTHORS(String sYS_AUTHORS) {
		SYS_AUTHORS = sYS_AUTHORS;
	}
	
	public Integer getP_SrcID() {
		return P_SrcID;
	}
	public void setP_SrcID(Integer p_SrcID) {
		P_SrcID = p_SrcID;
	}
	public String getSYS_CURRENTSTATUS() {
		return SYS_CURRENTSTATUS;
	}
	public void setSYS_CURRENTSTATUS(String sYS_CURRENTSTATUS) {
		SYS_CURRENTSTATUS = sYS_CURRENTSTATUS;
	}
	public Long getSYS_DOCUMENTiD() {
		return SYS_DOCUMENTiD;
	}
	public void setSYS_DOCUMENTiD(Long sYS_DOCUMENTiD) {
		SYS_DOCUMENTiD = sYS_DOCUMENTiD;
	}
	public Date getSYS_CREaTED() {
		return SYS_CREaTED;
	}
	public void setSYS_CREaTED(Date sYS_CREaTED) {
		SYS_CREaTED = sYS_CREaTED;
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
	public String getsYSCURRENTUSERNAME() {
		return sYSCURRENTUSERNAME;
	}
	public void setsYSCURRENTUSERNAME(String sYSCURRENTUSERNAME) {
		this.sYSCURRENTUSERNAME = sYSCURRENTUSERNAME;
	}
	
	public Long getpOrderiD() {
		return pOrderiD;
	}
	public void setpOrderiD(Long pOrderiD) {
		this.pOrderiD = pOrderiD;
	}
	public Long getP_Customer_iD() {
		return p_Customer_iD;
	}
	public void setP_Customer_iD(Long p_Customer_iD) {
		this.p_Customer_iD = p_Customer_iD;
	}
	public String getpCustomer() {
		return pCustomer;
	}
	public void setpCustomer(String pCustomer) {
		this.pCustomer = pCustomer;
	}
	public Long getP_Salesman_iD() {
		return P_Salesman_iD;
	}
	public void setP_Salesman_iD(Long p_Salesman_iD) {
		P_Salesman_iD = p_Salesman_iD;
	}
	public String getpSalesman() {
		return pSalesman;
	}
	public void setpSalesman(String pSalesman) {
		this.pSalesman = pSalesman;
	}
	public int getPpublicationiD() {
		return ppublicationiD;
	}
	public void setPpublicationiD(int ppublicationiD) {
		this.ppublicationiD = ppublicationiD;
	}
	public String getP_publication() {
		return p_publication;
	}
	public void setP_publication(String p_publication) {
		this.p_publication = p_publication;
	}
	public int getPpayModeiD() {
		return ppayModeiD;
	}
	public void setPpayModeiD(int ppayModeiD) {
		this.ppayModeiD = ppayModeiD;
	}
	public String getPpaymode() {
		return ppaymode;
	}
	public void setPpaymode(String ppaymode) {
		this.ppaymode = ppaymode;
	}
	public Double getP_amount() {
		return p_amount;
	}
	public void setP_amount(Double p_amount) {
		this.p_amount = p_amount;
	}
	
	public Double getAmountleft() {
		return amountleft;
	}
	public void setAmountleft(Double amountleft) {
		this.amountleft = amountleft;
	}
	public Double getPamountout() {
		return pamountout;
	}
	public void setPamountout(Double pamountout) {
		this.pamountout = pamountout;
	}
	public Double getPamountback() {
		return pamountback;
	}
	public void setPamountback(Double pamountback) {
		this.pamountback = pamountback;
	}
	public String getPinvoiceno() {
		return pinvoiceno;
	}
	public void setPinvoiceno(String pinvoiceno) {
		this.pinvoiceno = pinvoiceno;
	}
	public Double getPinvoiceablemoney() {
		return pinvoiceablemoney;
	}
	public void setPinvoiceablemoney(Double pinvoiceablemoney) {
		this.pinvoiceablemoney = pinvoiceablemoney;
	}
	public Double getPinvoicedmoney() {
		return pinvoicedmoney;
	}
	public void setPinvoicedmoney(Double pinvoicedmoney) {
		this.pinvoicedmoney = pinvoicedmoney;
	}
	public Double getPbalanceablemoney() {
		return pbalanceablemoney;
	}
	public void setPbalanceablemoney(Double pbalanceablemoney) {
		this.pbalanceablemoney = pbalanceablemoney;
	}
	public Double getPbalancedmoney() {
		return pbalancedmoney;
	}
	public void setPbalancedmoney(Double pbalancedmoney) {
		this.pbalancedmoney = pbalancedmoney;
	}
	public Double getPbalancedreal() {
		return pbalancedreal;
	}
	public void setPbalancedreal(Double pbalancedreal) {
		this.pbalancedreal = pbalancedreal;
	}
	public int getP_Type() {
		return p_Type;
	}
	public void setP_Type(int p_Type) {
		this.p_Type = p_Type;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	public Long getP_OperatoriD() {
		return p_OperatoriD;
	}
	public void setP_OperatoriD(Long p_OperatoriD) {
		this.p_OperatoriD = p_OperatoriD;
	}
	public int getPhasleft() {
		return phasleft;
	}
	public void setPhasleft(int phasleft) {
		this.phasleft = phasleft;
	}
	public int getPhasreceipt() {
		return phasreceipt;
	}
	public void setPhasreceipt(int phasreceipt) {
		this.phasreceipt = phasreceipt;
	}
	public int getPhasout() {
		return phasout;
	}
	public void setPhasout(int phasout) {
		this.phasout = phasout;
	}
	public int getPhasback() {
		return phasback;
	}
	public void setPhasback(int phasback) {
		this.phasback = phasback;
	}
	public int getpLocked() {
		return pLocked;
	}
	public void setpLocked(int pLocked) {
		this.pLocked = pLocked;
	}
	public String getP_Memo() {
		return p_Memo;
	}
	public void setP_Memo(String p_Memo) {
		this.p_Memo = p_Memo;
	}

	
	
}
