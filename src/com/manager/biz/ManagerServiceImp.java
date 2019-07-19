package com.manager.biz;

import com.colin.entity.Teacher;
import com.manager.dao.ManagerDaoI;
import com.manager.dao.ManagerDaoImp;

public class ManagerServiceImp implements ManagerServiceI{
	ManagerDaoI managerDaol = new ManagerDaoImp();
	/**
	 * 添加教师的方法 参数为一个teacher对象
	 * 去dao层找方法
	 */
	@Override
	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		if(null!=teacher) {
			return managerDaol.insertTea(teacher);
		}else {
			return false;
		}
	}
	/**
	 * 删除教师的方法 参数为一个id根据id删除
	 * 去dao层找方法
	 */
	@Override
	public boolean delTeacher(String id2) {
		// TODO Auto-generated method stub
		return managerDaol.deleteTea(id2);
	}
	/**
	 * 删除教师的方法 参数为一个id根据id查找
	 * 去dao层找方法
	 */
	@Override
	public Teacher findTeacherById(String id4) {
		// TODO Auto-generated method stub
		return managerDaol.selectTea(id4);
	}
	/**
	 * 修改老师的信息 参数为 目标id 和要修改成什么样子
	 */
	@Override
	public boolean altTeacherById(String id3, Teacher teacher3) {
		// TODO Auto-generated method stub
		return managerDaol.updateTea(id3,teacher3) ;
	}

	

}
