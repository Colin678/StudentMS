package com.manager.biz;

import com.colin.entity.Teacher;

public interface ManagerServiceI {
	
	/**
	 * 添加教师的方法
	 * 返回是否添加成功
	 * @param teacher
	 */
	public boolean addTeacher(Teacher teacher);

	/**
	 * 删除教师的方法
	 * 返回是否添加成功
	 * @param teacher
	 */
	public boolean delTeacher(String id2);

	public Teacher findTeacherById(String id4);

	public boolean altTeacherById(String id3, Teacher teacher3);

}
