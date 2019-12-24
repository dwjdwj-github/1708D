package com.daiwenjie.cms.domain;

/**
 * 投诉类型实体类
 * 
 * @author Administrator
 *
 */
public class ComType {
	public Integer id;
	public String ctype;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public ComType(Integer id, String ctype) {
		super();
		this.id = id;
		this.ctype = ctype;
	}

	public ComType() {
		super();
	}

	@Override
	public String toString() {
		return "ComType [id=" + id + ", ctype=" + ctype + "]";
	}

}
