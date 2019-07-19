package com.student.achievement.dao;

import java.sql.SQLException;

import com.colin.entity.Achievement;
import com.util.DBUtil;

public class MyAchiDaoImp extends DBUtil implements MyAchiDaoI{

	@Override
	public Achievement selectById(String id) {
		// TODO Auto-generated method stub
		Achievement achievement = new Achievement();
		String sql = "select * from achievement where id = ?";
		Object[] objarr = {id};
		rs=querySql(sql, objarr);
		try {
			while(rs.next()) {
				achievement.setChinese(rs.getDouble("chinese"));
				achievement.setMath(rs.getDouble("math"));
				achievement.setEnglish(rs.getDouble("english"));
				achievement.setSum(rs.getDouble("sum"));
				achievement.setAvg(rs.getDouble("avg"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return achievement;
	}

}
