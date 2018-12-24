package com.lt.cloud.pojo.adv;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AdvBase implements Serializable{
	private Long SYS_DOCUMENTID;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_CREATED;
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date SYS_LASTMODIFIED;
	private int SYS_ISLOCKED;
	private Long SYS_CURRENTUSERID;
	private String SYS_CURRENTUSERNAME;
	private String SYS_AUTHORS;
	private int SYS_ISKEEP;
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
	public int getSYS_ISLOCKED() {
		return SYS_ISLOCKED;
	}
	public void setSYS_ISLOCKED(int sYS_ISLOCKED) {
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
	public int getSYS_ISKEEP() {
		return SYS_ISKEEP;
	}
	public void setSYS_ISKEEP(int sYS_ISKEEP) {
		SYS_ISKEEP = sYS_ISKEEP;
	}
		
}
