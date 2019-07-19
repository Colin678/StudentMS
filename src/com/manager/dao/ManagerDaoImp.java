package com.manager.dao;

import java.sql.SQLException;

import com.colin.entity.Teacher;
import com.util.DBUtil;
import com.util.MD5Util;

public class ManagerDaoImp extends DBUtil implements ManagerDaoI{

	@Override
	public boolean insertTea(Teacher teacher) {
		//添加了一名老师 如果添加成功那么也要在user表里添加这条记录  
		int i=0;
		String sql="insert into teacher values(?,?,?,1,'teacher')";
		Object[] objarr = {teacher.getId(),MD5Util.md5Password("123456"),teacher.getName()};
		if(selectTea(teacher.getId())==null) {
			i=querySqlint(sql, objarr);
		}
		
		if(i!=0) {
			//这是在user表里的操作
			String sql1 = "insert into user values(?,?,'teacher')";
			Object[] objarr1 = {teacher.getId(),MD5Util.md5Password("123456")};
			querySqlint(sql1, objarr1);
			System.out.println(i+teacher.getName());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteTea(String id2) {
		int i=0;
		String sql="update teacher set state = 0 where id = ?";
		Object[] objarr = {id2};
		i=querySqlint(sql, objarr);
		if(i!=0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Teacher selectTea(String id4) {
		// TODO Auto-generated method stub
		String sql ="select id,name,state from teacher where id = ?";
		Object[] objarr= {id4};
		rs=querySql(sql, objarr);
		Teacher teacher = null;
		try {
			while(rs.next()) {
				teacher = new Teacher();
				teacher.setId(rs.getString("id"));
				teacher.setName(rs.getString("name"));
				teacher.setState(rs.getInt("state"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public boolean updateTea(String id, Teacher teacher) {
		System.out.println("在use表里  我们要操作的是"+id);
		System.out.println("我们要把他的id变为"+teacher.getId());
		//这是更新老师的信息   如果把老师的id改了 那么user表的id也要改变所以 还需要再此方法里更新user表
		int i=0;
		String sql = "update teacher set id = ?,name = ? where id = "+id;
		System.out.println("update teacher set id = "+teacher.getId()+",name = "+teacher.getName()+" where id = "+id);
		Object[] objarr = {teacher.getId(),teacher.getName()};
		i=querySqlint(sql, objarr);
		
		//这是对user表的操作
		System.out.println("teacher表执行后在use表里  我们要操作的是"+id);
		System.out.println("teacher表执行后我们要把他的id变为"+teacher.getId());
		String sql1 = "update user set uid = ? where uid = "+"'"+id+"'";
		
		System.out.println("update user set uid = "+teacher.getId()+" where uid = "+id);
		Object[] objarr1 = {teacher.getId()};
		querySqlint(sql1, objarr1);
		if(i==0) {
			return false;
		}else {
			return true;
		}
	}


}
