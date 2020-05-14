package com.tledu.zmj.model;

import java.util.Date;

public class Note {
	private int id;
	private String title;
	private String content;
	private User user;
	private Date creat_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getCreat_date() {
		return creat_date;
	}
	public void setCreat_date(Date creat_date) {
		this.creat_date = creat_date;
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", user=" + user + ", creat_date="
				+ creat_date + ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getContent()=" + getContent()
				+ ", getUser()=" + getUser() + ", getCreat_date()=" + getCreat_date() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
}
