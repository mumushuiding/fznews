package com.lt.cloud.pojo.adv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Advdoc extends AdvBase{
	private Long F_OrderID;
	private String F_Size;
	private int F_Size_ID;
	private String F_Color;
	private int F_Color_ID;
	private String F_Content;
	private double F_Width;
	private double F_Height;
	private String F_TextContent;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date F_UploadTime;
	private String F_Memo;
	public Long getF_OrderID() {
		return F_OrderID;
	}
	public void setF_OrderID(Long f_OrderID) {
		F_OrderID = f_OrderID;
	}
	public String getF_Size() {
		return F_Size;
	}
	public void setF_Size(String f_Size) {
		F_Size = f_Size;
	}
	public int getF_Size_ID() {
		return F_Size_ID;
	}
	public void setF_Size_ID(int f_Size_ID) {
		F_Size_ID = f_Size_ID;
	}
	public String getF_Color() {
		return F_Color;
	}
	public void setF_Color(String f_Color) {
		F_Color = f_Color;
	}
	public int getF_Color_ID() {
		return F_Color_ID;
	}
	public void setF_Color_ID(int f_Color_ID) {
		F_Color_ID = f_Color_ID;
	}
	public String getF_Content() {
		return F_Content;
	}
	public void setF_Content(String f_Content) {
		F_Content = f_Content;
	}
	public double getF_Width() {
		return F_Width;
	}
	public void setF_Width(double f_Width) {
		F_Width = f_Width;
	}
	public double getF_Height() {
		return F_Height;
	}
	public void setF_Height(double f_Height) {
		F_Height = f_Height;
	}
	public String getF_TextContent() {
		return F_TextContent;
	}
	public void setF_TextContent(String f_TextContent) {
		F_TextContent = f_TextContent;
	}
	public Date getF_UploadTime() {
		return F_UploadTime;
	}
	public void setF_UploadTime(Date f_UploadTime) {
		F_UploadTime = f_UploadTime;
	}
	public String getF_Memo() {
		return F_Memo;
	}
	public void setF_Memo(String f_Memo) {
		F_Memo = f_Memo;
	}
	
	
}
