package com.student.dao;

import com.util.DBUtil;

public class StudentDaoImp extends DBUtil implements StudentDaoI{
	/**
	 * 根据id修改student表里面的密码 同时也要修改user表里的密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	@Override
	public boolean updatePwdById(String id, String pwd) {
		// TODO Auto-generated method stub
		//先改student的     再改user的
		String sql = "update student set stupwd = "+"'"+pwd+"'"+" where id = "+"'"+id+"'";
		Object[] objarr = {id,pwd};
		querySqlint(sql, null);
		
		//修改user表的
		String sql1 = "update user set upwd = "+"'"+pwd+"'"+" where uid = "+"'"+id+"'";
		Object[] objarr1 = {id,pwd};
		if(querySqlint(sql1, null)!=0) {
			return true;
		}else {
			return false;
		}
		
	}

}
