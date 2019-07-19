package com.colin.entity;

import java.io.Serializable;

public class Manager implements Serializable{
	private String id;//id表的主键
	private String mpwd;//密码
	private String name;//名字
	
	public Manager() {
	}
	
	public Manager(String mid, String mpwd, String mname) {
		this.id = mid;
		this.mpwd = mpwd;
		this.name = mname;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String mid) {
		this.id = mid;
	}
	public String getMpwd() {
		return mpwd;
	}
	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String mname) {
		this.name = mname;
	}
	
}
