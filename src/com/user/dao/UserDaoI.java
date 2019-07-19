package com.user.dao;

import com.colin.entity.User;

public interface UserDaoI {
	/**
	 * 
	 */
	public User queryByUser(User user);
	/**
	 * 
	 * @param uid
	 * @return
	*/
	public String queryNameByUid(String uid,String utype);
	/**
	 * 
	 * @param uid
	 * @param utype
	 * @return
	 */
	public boolean queryStateByUid(String uid, String utype);
}
