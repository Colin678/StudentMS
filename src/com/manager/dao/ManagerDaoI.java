package com.manager.dao;

import com.colin.entity.Teacher;

public interface ManagerDaoI {
	/**
	 * insert一个老师入teacher数据库
	 * @param teacher
	 * @return
	 */
	public boolean insertTea(Teacher teacher);

	/**
	 * delete一个老师从teacher数据库
	 * @param id2
	 * @return
	 */
	public boolean deleteTea(String id2);

	/**
	 * select一个老师从teacher数据库
	 * @param id2
	 * @return
	 */
	public Teacher selectTea(String id4);

	public boolean updateTea(String id,Teacher teacher);

}
