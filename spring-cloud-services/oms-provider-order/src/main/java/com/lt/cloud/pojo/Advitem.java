package com.lt.cloud.pojo;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Advitem{

	private Long SYS_DOCUMENTID;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_CREATED;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_LASTMODIFIED;
	private Integer SYS_ISLOCKED;
	private Long SYS_CURRENTUSERID;
	private String SYS_CURRENTUSERNAME;
	private String SYS_AUTHORS;
	private Integer SYS_ISKEEP;
	private Long AI_OrderID;//advdoc
	private Integer AI_Size_ID;//advdoc
	private String AI_Size;//advdoc
	private Double AI_Width;//advdoc
	private Double AI_Height;//advdoc
	private Integer AI_Color_ID;
	private String AI_Color;
	private String AI_Content;
	private Long AI_Customer_ID;
	private String AI_Customer;
	private Long AI_Agent_ID;
	private String AI_Agent;
	private Long AI_Advertiser_ID;
	private String AI_Advertiser;
	private Long AI_Org_ID;
	private String AI_Org;
	private Long AI_Salesman_ID;
	private String AI_Salesman;
	private Integer AI_Type;
	private Integer AI_Publication_ID;
	private String AI_Publication;
	private Integer AI_Edition_ID;
	private String AI_Edition;
	private Integer AI_AdType_ID;
	private String AI_AdType;
	private Integer AI_TradeID;
	private String AI_Trade;
	private Integer AI_Field_ID;
	private String AI_Field;
	private Integer AI_PriceModeIC ;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String AI_PublishTime;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private String AI_PublishEndTime;
	private Integer AI_PublishDayCount;
	private Integer AI_Week;
	private Integer AI_PayMode_ID;
	private String AI_PayMode;
	private Integer AI_PriceList_ID;
	private String AI_PriceList;
	private Double AI_Price;
	private Double AI_UnitPrice;
	private Double AI_DiscountTotal;
	private Double AI_AdditionalFee;
	private Double AI_AmountReceivable;
	private Double AI_AmountPaid;
	private Double AI_AmountRelief;
	private Double AI_AmountReceived;
	private Double AI_Debt;
	private Double AI_BadDebt;
	private Double AI_RebateMoney;
	private Double AI_InvoicedMoney;
	private Double AI_UninvoicedMoney;
	private Double AI_BalancedMoney;
	private Double AI_UnbalancedMoney;
	private Integer AI_PayStatus;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date AI_PayTime;
	private Double AI_AdvPages;
	private String AI_InvoiceNo;
	private Long AI_OperatorID;
	private Double AI_Area ;
	private String  AI_PubMemo ;
	private String AI_Memo;
	private Long AI_ArticleID;
	
	public Long getAI_ArticleID() {
		return AI_ArticleID;
	}
	public void setAI_ArticleID(Long aI_ArticleID) {
		AI_ArticleID = aI_ArticleID;
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
	public Integer getSYS_ISLOCKED() {
		return SYS_ISLOCKED;
	}
	public void setSYS_ISLOCKED(Integer sYS_ISLOCKED) {
		SYS_ISLOCKED = sYS_ISLOCKED;
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
	public Integer getSYS_ISKEEP() {
		return SYS_ISKEEP;
	}
	public void setSYS_ISKEEP(Integer sYS_ISKEEP) {
		SYS_ISKEEP = sYS_ISKEEP;
	}
	public Long getAI_OrderID() {
		return AI_OrderID;
	}
	public void setAI_OrderID(Long aI_OrderID) {
		AI_OrderID = aI_OrderID;
	}
	public Integer getAI_Size_ID() {
		return AI_Size_ID;
	}
	public void setAI_Size_ID(Integer aI_Size_ID) {
		AI_Size_ID = aI_Size_ID;
	}
	public String getAI_Size() {
		return AI_Size;
	}
	public void setAI_Size(String aI_Size) {
		AI_Size = aI_Size;
	}
	public Double getAI_Width() {
		return AI_Width;
	}
	public void setAI_Width(Double aI_Width) {
		AI_Width = aI_Width;
	}
	public Double getAI_Height() {
		return AI_Height;
	}
	public void setAI_Height(Double aI_Height) {
		AI_Height = aI_Height;
	}
	public Integer getAI_Color_ID() {
		return AI_Color_ID;
	}
	public void setAI_Color_ID(Integer aI_Color_ID) {
		AI_Color_ID = aI_Color_ID;
	}
	public String getAI_Color() {
		return AI_Color;
	}
	public void setAI_Color(String aI_Color) {
		AI_Color = aI_Color;
	}
	public String getAI_Content() {
		return AI_Content;
	}
	public void setAI_Content(String aI_Content) {
		AI_Content = aI_Content;
	}

	public Long getAI_Customer_ID() {
		return AI_Customer_ID;
	}
	public void setAI_Customer_ID(Long aI_Customer_ID) {
		AI_Customer_ID = aI_Customer_ID;
	}
	public String getAI_Customer() {
		return AI_Customer;
	}
	public void setAI_Customer(String aI_Customer) {
		AI_Customer = aI_Customer;
	}
	public Long getAI_Agent_ID() {
		return AI_Agent_ID;
	}
	public void setAI_Agent_ID(Long aI_Agent_ID) {
		AI_Agent_ID = aI_Agent_ID;
	}
	public String getAI_Agent() {
		return AI_Agent;
	}
	public void setAI_Agent(String aI_Agent) {
		AI_Agent = aI_Agent;
	}
	public Long getAI_Advertiser_ID() {
		return AI_Advertiser_ID;
	}
	public void setAI_Advertiser_ID(Long aI_Advertiser_ID) {
		AI_Advertiser_ID = aI_Advertiser_ID;
	}
	public String getAI_Advertiser() {
		return AI_Advertiser;
	}
	public void setAI_Advertiser(String aI_Advertiser) {
		AI_Advertiser = aI_Advertiser;
	}
	public Long getAI_Org_ID() {
		return AI_Org_ID;
	}
	public void setAI_Org_ID(Long aI_Org_ID) {
		AI_Org_ID = aI_Org_ID;
	}
	public String getAI_Org() {
		return AI_Org;
	}
	public void setAI_Org(String aI_Org) {
		AI_Org = aI_Org;
	}
	public Long getAI_Salesman_ID() {
		return AI_Salesman_ID;
	}
	public void setAI_Salesman_ID(Long aI_Salesman_ID) {
		AI_Salesman_ID = aI_Salesman_ID;
	}
	public String getAI_Salesman() {
		return AI_Salesman;
	}
	public void setAI_Salesman(String aI_Salesman) {
		AI_Salesman = aI_Salesman;
	}
	public Integer getAI_Type() {
		return AI_Type;
	}
	public void setAI_Type(Integer aI_Type) {
		AI_Type = aI_Type;
	}
	public Integer getAI_Publication_ID() {
		return AI_Publication_ID;
	}
	public void setAI_Publication_ID(Integer aI_Publication_ID) {
		AI_Publication_ID = aI_Publication_ID;
	}
	public String getAI_Publication() {
		return AI_Publication;
	}
	public void setAI_Publication(String aI_Publication) {
		AI_Publication = aI_Publication;
	}
	public Integer getAI_Edition_ID() {
		return AI_Edition_ID;
	}
	public void setAI_Edition_ID(Integer aI_Edition_ID) {
		AI_Edition_ID = aI_Edition_ID;
	}
	public String getAI_Edition() {
		return AI_Edition;
	}
	public void setAI_Edition(String aI_Edition) {
		AI_Edition = aI_Edition;
	}
	public Integer getAI_AdType_ID() {
		return AI_AdType_ID;
	}
	public void setAI_AdType_ID(Integer aI_AdType_ID) {
		AI_AdType_ID = aI_AdType_ID;
	}
	public String getAI_AdType() {
		return AI_AdType;
	}
	public void setAI_AdType(String aI_AdType) {
		AI_AdType = aI_AdType;
	}
	public Integer getAI_TradeID() {
		return AI_TradeID;
	}
	public void setAI_TradeID(Integer aI_TradeID) {
		AI_TradeID = aI_TradeID;
	}
	public String getAI_Trade() {
		return AI_Trade;
	}
	public void setAI_Trade(String aI_Trade) {
		AI_Trade = aI_Trade;
	}
	public Integer getAI_Field_ID() {
		return AI_Field_ID;
	}
	public void setAI_Field_ID(Integer aI_Field_ID) {
		AI_Field_ID = aI_Field_ID;
	}
	public String getAI_Field() {
		return AI_Field;
	}
	public void setAI_Field(String aI_Field) {
		AI_Field = aI_Field;
	}
	public Integer getAI_PriceModeIC() {
		return AI_PriceModeIC;
	}
	public void setAI_PriceModeIC(Integer aI_PriceModeIC) {
		AI_PriceModeIC = aI_PriceModeIC;
	}
	public String getAI_PublishTime() {
		return AI_PublishTime;
	}
	public void setAI_PublishTime(String aI_PublishTime) {
		AI_PublishTime = aI_PublishTime;
	}
	public String getAI_PublishEndTime() {
		return AI_PublishEndTime;
	}
	public void setAI_PublishEndTime(String aI_PublishEndTime) {
		AI_PublishEndTime = aI_PublishEndTime;
	}
	public Integer getAI_PublishDayCount() {
		return AI_PublishDayCount;
	}
	public void setAI_PublishDayCount(Integer aI_PublishDayCount) {
		AI_PublishDayCount = aI_PublishDayCount;
	}
	public Integer getAI_Week() {
		return AI_Week;
	}
	public void setAI_Week(Integer aI_Week) {
		AI_Week = aI_Week;
	}
	public Integer getAI_PayMode_ID() {
		return AI_PayMode_ID;
	}
	public void setAI_PayMode_ID(Integer aI_PayMode_ID) {
		AI_PayMode_ID = aI_PayMode_ID;
	}
	public String getAI_PayMode() {
		return AI_PayMode;
	}
	public void setAI_PayMode(String aI_PayMode) {
		AI_PayMode = aI_PayMode;
	}
	public Integer getAI_PriceList_ID() {
		return AI_PriceList_ID;
	}
	public void setAI_PriceList_ID(Integer aI_PriceList_ID) {
		AI_PriceList_ID = aI_PriceList_ID;
	}
	public String getAI_PriceList() {
		return AI_PriceList;
	}
	public void setAI_PriceList(String aI_PriceList) {
		AI_PriceList = aI_PriceList;
	}
	public Double getAI_Price() {
		return AI_Price;
	}
	public void setAI_Price(Double aI_Price) {
		AI_Price = aI_Price;
	}
	public Double getAI_UnitPrice() {
		return AI_UnitPrice;
	}
	public void setAI_UnitPrice(Double aI_UnitPrice) {
		AI_UnitPrice = aI_UnitPrice;
	}
	public Double getAI_DiscountTotal() {
		return AI_DiscountTotal;
	}
	public void setAI_DiscountTotal(Double aI_DiscountTotal) {
		AI_DiscountTotal = aI_DiscountTotal;
	}
	public Double getAI_AdditionalFee() {
		return AI_AdditionalFee;
	}
	public void setAI_AdditionalFee(Double aI_AdditionalFee) {
		AI_AdditionalFee = aI_AdditionalFee;
	}
	public Double getAI_AmountReceivable() {
		return AI_AmountReceivable;
	}
	public void setAI_AmountReceivable(Double aI_AmountReceivable) {
		AI_AmountReceivable = aI_AmountReceivable;
	}
	public Double getAI_AmountPaid() {
		return AI_AmountPaid;
	}
	public void setAI_AmountPaid(Double aI_AmountPaid) {
		AI_AmountPaid = aI_AmountPaid;
	}
	public Double getAI_AmountRelief() {
		return AI_AmountRelief;
	}
	public void setAI_AmountRelief(Double aI_AmountRelief) {
		AI_AmountRelief = aI_AmountRelief;
	}
	public Double getAI_AmountReceived() {
		return AI_AmountReceived;
	}
	public void setAI_AmountReceived(Double aI_AmountReceived) {
		AI_AmountReceived = aI_AmountReceived;
	}
	public Double getAI_Debt() {
		return AI_Debt;
	}
	public void setAI_Debt(Double aI_Debt) {
		AI_Debt = aI_Debt;
	}
	public Double getAI_BadDebt() {
		return AI_BadDebt;
	}
	public void setAI_BadDebt(Double aI_BadDebt) {
		AI_BadDebt = aI_BadDebt;
	}
	public Double getAI_RebateMoney() {
		return AI_RebateMoney;
	}
	public void setAI_RebateMoney(Double aI_RebateMoney) {
		AI_RebateMoney = aI_RebateMoney;
	}
	public Double getAI_InvoicedMoney() {
		return AI_InvoicedMoney;
	}
	public void setAI_InvoicedMoney(Double aI_InvoicedMoney) {
		AI_InvoicedMoney = aI_InvoicedMoney;
	}
	public Double getAI_UninvoicedMoney() {
		return AI_UninvoicedMoney;
	}
	public void setAI_UninvoicedMoney(Double aI_UninvoicedMoney) {
		AI_UninvoicedMoney = aI_UninvoicedMoney;
	}
	public Double getAI_BalancedMoney() {
		return AI_BalancedMoney;
	}
	public void setAI_BalancedMoney(Double aI_BalancedMoney) {
		AI_BalancedMoney = aI_BalancedMoney;
	}
	public Double getAI_UnbalancedMoney() {
		return AI_UnbalancedMoney;
	}
	public void setAI_UnbalancedMoney(Double aI_UnbalancedMoney) {
		AI_UnbalancedMoney = aI_UnbalancedMoney;
	}
	public Integer getAI_PayStatus() {
		return AI_PayStatus;
	}
	public void setAI_PayStatus(Integer aI_PayStatus) {
		AI_PayStatus = aI_PayStatus;
	}
	public Date getAI_PayTime() {
		return AI_PayTime;
	}
	public void setAI_PayTime(Date aI_PayTime) {
		AI_PayTime = aI_PayTime;
	}
	public Double getAI_AdvPages() {
		return AI_AdvPages;
	}
	public void setAI_AdvPages(Double aI_AdvPages) {
		AI_AdvPages = aI_AdvPages;
	}
	public String getAI_InvoiceNo() {
		return AI_InvoiceNo;
	}
	public void setAI_InvoiceNo(String aI_InvoiceNo) {
		AI_InvoiceNo = aI_InvoiceNo;
	}
	public Long getAI_OperatorID() {
		return AI_OperatorID;
	}
	public void setAI_OperatorID(Long aI_OperatorID) {
		AI_OperatorID = aI_OperatorID;
	}
	public Double getAI_Area() {
		return AI_Area;
	}
	public void setAI_Area(Double aI_Area) {
		AI_Area = aI_Area;
	}
	public String getAI_PubMemo() {
		return AI_PubMemo;
	}
	public void setAI_PubMemo(String aI_PubMemo) {
		AI_PubMemo = aI_PubMemo;
	}
	public String getAI_Memo() {
		return AI_Memo;
	}
	public void setAI_Memo(String aI_Memo) {
		AI_Memo = aI_Memo;
	}
	
}
