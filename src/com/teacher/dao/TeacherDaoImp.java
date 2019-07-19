package com.teacher.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.colin.entity.Student;
import com.util.DBUtil;
import com.util.MD5Util;

public class TeacherDaoImp extends DBUtil implements TeacherDaoI{

	@Override
	public boolean insertStu(Student student1) {
		int i=0;
		//向student表里添加一名学生 密码加密 如果添加成功那么也要在user表里添加这条记录  
		String sql = "insert into student values(?,?,?,1,'student')";
		Object[] objarr = {student1.getId(),MD5Util.md5Password("123456"),student1.getName()};
		
		i=querySqlint(sql, objarr);
		
		
		if(i==0) {
			return false;
		}else {
			//同时也要向user表里添加一条记录
			String sql1 = "insert into user values(?,?,'student')";
			Object[] objarr1 = {student1.getId(),MD5Util.md5Password("123456")};
			System.out.println(sql1);
			querySqlint(sql1, objarr1);
			System.out.println(i+student1.getName());
			System.out.println("开始插入user了吗？");
			return true;
		}
	}

	@Override
	public boolean deleteStu(String id2) {
		int i=0;
		String sql = "update student set state = 0 where id = ?";
		Object[] objarr= {id2};
		i=querySqlint(sql, objarr);
		System.out.println(sql+"--------"+i);
		if(i==0) {
			
			return false;
		}else {
			return true;
		}
	}

	@Override
	public List<Student> selectStuByState(int state) {
		List<Student> stulist = new ArrayList<>();
		String sql = "select * from student where state = ?";
		Object[] objarr = {state};
		rs=querySql(sql, objarr);
		try {
			while(rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setId(rs.getString("id"));
				stulist.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stulist;
	}

	@Override
	public boolean alterStuById(String id, Student student4) {
		//根据id 和对象操作student表
		int i =0;
		System.out.println("------------------------------------------------------------"+id);
		String sql = "update student set id = ?,name = ?,state = ? where id = ? ";
		Object[] objarr = {student4.getId(),student4.getName(),student4.getState(),id};
		i=querySqlint(sql, objarr);
		if(i==0) {
			return false;
		}else {
			return true;
		}
		
	}

}
