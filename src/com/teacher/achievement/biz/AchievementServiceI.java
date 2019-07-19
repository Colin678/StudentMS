package com.teacher.achievement.biz;

import com.colin.entity.Achievement;

public interface AchievementServiceI {
	/**
	 * 添加一条成绩记录
	 * @param achievement1
	 * @return
	 */
	public boolean addAchi(Achievement achievement1);
	/**
	 * 修改一条成绩记录
	 * @param achievement1
	 * @return
	 */
	public boolean altAchi(Achievement achievement2);
	

}
