package com.user.dao;

import java.sql.SQLException;

import com.colin.entity.User;
import com.util.DBUtil;

public class UserDaoImp extends DBUtil implements UserDaoI{
	/**
	 * 从user表里查是否有此人及能否对上号
	 */
	@Override
	public User queryByUser(User user) {
		// TODO Auto-generated method stub
		String sql="select uid,upwd,utype from user where uid=? and upwd =? and utype = ?";
		Object[] objarr= {user.getUid(),user.getUpwd(),user.getUtype()};
		rs=querySql(sql, objarr);
		User user2 = new User();
		try {
			while(rs.next()) {
				user2.setUid(rs.getString("uid"));
				user2.setUpwd(rs.getString("upwd"));
				user2.setUtype(rs.getString("utype"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user2;
	}
	/**
	 * 用在首页显示   欢迎   谁的可以根据id获取name
	 */
	@Override
	public String queryNameByUid(String uid,String utype) {
		String name =null;
		String sql = "select name from "+utype+" where id = ?";
		Object[] objarr = {uid};
		try {
			rs=querySql(sql, objarr);
			while(rs.next()) {
				name=rs.getString("name");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	/**
	 * 在user表里查到此人  但是的看她是否在职或者退学毕业
	 */
	@Override
	public boolean queryStateByUid(String uid, String utype) {
		int state = 0;
		String sql = "select state from "+utype+" where id = ?";
		Object[] objarr = {uid};
		rs=querySql(sql, objarr);
		try {
			while(rs.next()) {
				state=rs.getInt("state");
				if(state==1) {
					return true;
				}else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
