package com.student.biz;

import com.student.dao.StudentDaoI;
import com.student.dao.StudentDaoImp;

public class StudentServiceImp implements StudentServiceI{
	StudentDaoI studentDaoI = new StudentDaoImp();
	/**
	 * 根据id修改student表里面的密码 同时也要修改user表里的密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	@Override
	public boolean altPwdById(String id, String pwd) {
		// TODO Auto-generated method stub
		return studentDaoI.updatePwdById(id,pwd);
	}

}
