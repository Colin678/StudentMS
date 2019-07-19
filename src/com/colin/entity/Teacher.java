package com.colin.entity;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String id;//老师id
	private String tpwd;//老师密码
	private String name;//老师名字
	private int state;//老师状态 0 为离职 1为在职
	
	public Teacher() {
	}
	public Teacher(String tid, String tpwd, String tname, int state) {
		this.id = tid;
		this.tpwd = tpwd;
		this.name = tname;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String tid) {
		this.id = tid;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String tname) {
		this.name = tname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
