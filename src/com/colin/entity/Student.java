package com.colin.entity;

import java.io.Serializable;

public class Student implements Serializable{
	private String id;//id 表的主键
	private String spwd;//密码
	private String name;//名字
	private int state;//在学状态  0为退学/毕业   1为在读
	
	public Student() {
	}
	
	public Student(String sid, String spwd, String sname, int state) {
		this.id = sid;
		this.spwd = spwd;
		this.name = sname;
		this.state = state;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String sid) {
		this.id = sid;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String sname) {
		this.name = sname;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
