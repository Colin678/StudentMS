package com.teacher.achievement.biz;

import com.colin.entity.Achievement;
import com.teacher.achievement.dao.AchievementDaoI;
import com.teacher.achievement.dao.AchievementDaoImp;

public class AchievementServiceImp implements AchievementServiceI{
	AchievementDaoI achievementDaoI = new AchievementDaoImp();
	/**
	 * 添加一条成绩记录
	 */
	@Override
	public boolean addAchi(Achievement achievement1) {
		// TODO Auto-generated method stub
		return achievementDaoI.inserAchi(achievement1);
	}
	/**
	 * 修改一条成绩记录
	 */
	@Override
	public boolean altAchi(Achievement achievement2) {
		// TODO Auto-generated method stub
		return achievementDaoI.updateAchi(achievement2);
	}

}
