package com.student.achievement.biz;

import com.colin.entity.Achievement;

public interface MyAchiServiceI {
	/**
	 * 向dao层查询该id的记录
	 * @param id
	 */
	public Achievement findById(String id);

}
