package com.teacher.biz;

import java.util.List;

import com.colin.entity.Student;
import com.teacher.dao.TeacherDaoI;
import com.teacher.dao.TeacherDaoImp;

public class TeacherServiceImp implements TeacherServiceI{
	TeacherDaoI teacherDaoI = new TeacherDaoImp();
	/**
	 * 添加一名学生
	 * 参数为一个从页面获取数据而new出来的学生对象   去dao层调用
	 * @param student1
	 * @return
	 */
	@Override
	public boolean addStu(Student student1) {
		// TODO Auto-generated method stub
		return teacherDaoI.insertStu(student1);
	}
	/**
	 * 删除一名学生
	 * 参数为一个从页面获取数据的id 去daoceng调用
	 * @param student1
	 * @return
	 */
	@Override
	public boolean delStu(String id2) {
		// TODO Auto-generated method stub
		return teacherDaoI.deleteStu(id2);
	}
	/**
	 * 根据state的值去dao层找
	 */
	@Override
	public List<Student> findStu(int state) {
		// TODO Auto-generated method stub
		return teacherDaoI.selectStuByState(state);
	}
	/**
	 * 根据id 找到记录修改为student4
	 * @param id
	 * @param student4
	 */
	@Override
	public boolean altStudentById(String id, Student student4) {
		// TODO Auto-generated method stub
		return teacherDaoI.alterStuById(id,student4);
	}

}
