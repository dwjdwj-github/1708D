package com.daiwenjie.cms.domain;

import java.util.Date;
/**
 *  说明:评论表
 * @author Administrator
 *
 */
public class Comment {

	private Integer id;
	private String content;
	private User author;
	private Article blog;
	private Date displayTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Article getBlog() {
		return blog;
	}
	public void setBlog(Article blog) {
		this.blog = blog;
	}
	public Date getDisplayTime() {
		return displayTime;
	}
	public void setDisplayTime(Date displayTime) {
		this.displayTime = displayTime;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comment(Integer id, String content, User author, Article blog, Date displayTime) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.blog = blog;
		this.displayTime = displayTime;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", author=" + author + ", blog=" + blog + ", displayTime="
				+ displayTime + "]";
	}
	
	
	
	
}
