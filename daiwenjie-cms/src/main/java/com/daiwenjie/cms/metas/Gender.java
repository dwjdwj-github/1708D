/**
 * 
 */
package com.daiwenjie.cms.metas;

/**
 * 说明:性别
 * 枚举类
 * 
 * @author 
 * @version 1.0
 *

 */
public enum Gender {

	FAMALE("女士"),
	MALE("先生");
	
	private String description;
	
	private Gender(String description){
		this.description = description;
	}
	
	public String getName(){
		return name();
	}
	
	public String getDescription() {
		return description;
	}

	public int getOrdinal(){
		return this.ordinal();
	}
	
}
