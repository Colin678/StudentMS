package com.colin.entity;

import java.io.Serializable;

public class User implements Serializable{
	private String uid;
	private String upwd;
	private String utype;
	public User() {
	}
	
	public User(String uid, String upwd, String utype) {
		this.uid = uid;
		this.upwd = upwd;
		this.utype = utype;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}

}
