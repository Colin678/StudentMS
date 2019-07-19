package com.user.biz;

import com.colin.entity.User;
import com.user.dao.UserDaoI;
import com.user.dao.UserDaoImp;

public class UserServiceImp implements UserServiceI{
	
	UserDaoI userDaoI = new UserDaoImp();
	/**
	 * 实现接口的方法
	 */
	@Override
	public User findByUser(User user) {
		if(null!=user) {
			return userDaoI.queryByUser(user);	
		}else {
			return null;
		}
		
		
	}
	/**
	 * 实现接口的方法
	 * 参数uid，调用此方法时，已确定用户身份，即已知在哪张表里
	 */
	@Override
	public String findNameByUid(String uid,String utype) {
		if(null!=uid) {
			return userDaoI.queryNameByUid(uid,utype);	
		}else {
			return null;
		}
	}
	@Override
	public boolean findeStateByUid(String uid, String utype) {
		if(null!=uid) {
			return userDaoI.queryStateByUid(uid,utype);	
		}else {
			return false;
		}
	}

}
