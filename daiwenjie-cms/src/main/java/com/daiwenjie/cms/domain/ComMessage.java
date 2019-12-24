package com.daiwenjie.cms.domain;
/**
 * 投诉信息表
 * @author Administrator
 *
 */
public class ComMessage {
	public Integer id;
	public String realname;
	public String  phone;
	public String email;
	public String cominfo;
	public String murl;
	public Integer uid;
	public Integer tid;
	public Integer aid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCominfo() {
		return cominfo;
	}
	public void setCominfo(String cominfo) {
		this.cominfo = cominfo;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public ComMessage(Integer id, String realname, String phone, String email, String cominfo, String murl, Integer uid,
			Integer tid, Integer aid) {
		super();
		this.id = id;
		this.realname = realname;
		this.phone = phone;
		this.email = email;
		this.cominfo = cominfo;
		this.murl = murl;
		this.uid = uid;
		this.tid = tid;
		this.aid = aid;
	}
	public ComMessage() {
		super();
	}
	@Override
	public String toString() {
		return "ComMessage [id=" + id + ", realname=" + realname + ", phone=" + phone + ", email=" + email
				+ ", cominfo=" + cominfo + ", murl=" + murl + ", uid=" + uid + ", tid=" + tid + ", aid=" + aid + "]";
	}
	
	
}
