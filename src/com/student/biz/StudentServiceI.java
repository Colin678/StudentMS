package com.student.biz;

public interface StudentServiceI {
	/**
	 * 根据id修改student表里面的密码 同时也要修改user表里的密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	boolean altPwdById(String id, String pwd);

}
