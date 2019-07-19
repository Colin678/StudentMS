package com.teacher.achievement.dao;

import com.colin.entity.Achievement;
import com.util.DBUtil;

public class AchievementDaoImp extends DBUtil implements AchievementDaoI{

	@Override
	public boolean inserAchi(Achievement achievement1) {
		// TODO Auto-generated method stub
		int i = 0;
		String sql = "insert into achievement values(?,?,?,?,?,?,?)";
		Object[] objarr = {achievement1.getId(),achievement1.getName(),achievement1.getChinese(),achievement1.getMath(),achievement1.getEnglish(),achievement1.getSum(),achievement1.getAvg()};
		i=querySqlint(sql, objarr);
		if(i==1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public boolean updateAchi(Achievement achievement2) {
		// TODO Auto-generated method stub
		String sql ="update achievement set chinese = ?,math = ?,english = ?,sum = ?,avg = ? where id = ?";
		Object[] objarr = {achievement2.getChinese(),achievement2.getMath(),achievement2.getEnglish(),achievement2.getSum(),achievement2.getAvg(),achievement2.getId()};
		int i=querySqlint(sql, objarr);
		if(i!=0) {
			return true;
		}else {
			return false;
		}
		
	}

}
