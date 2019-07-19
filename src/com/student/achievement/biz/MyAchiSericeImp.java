package com.student.achievement.biz;

import com.colin.entity.Achievement;
import com.student.achievement.dao.MyAchiDaoI;
import com.student.achievement.dao.MyAchiDaoImp;

public class MyAchiSericeImp implements MyAchiServiceI{
	MyAchiDaoI myAchiDaoI = new MyAchiDaoImp();
	/**
	 * 向dao层查询成绩byid
	 */
	@Override
	public Achievement findById(String id) {
		// TODO Auto-generated method stub
		return myAchiDaoI.selectById(id);
	}

}
