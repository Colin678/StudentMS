package com.user.biz;

import com.colin.entity.User;

public interface UserServiceI {
	/**
	 * 参数，页面得到信息实例化出来的对象
	 * 返回一个User
	 * 进dao找此user   是否存在此条记录
	 */
	public User findByUser(User user);
	
	/**
	 * 参数uid，调用此方法时，已确定用户身份，即已知在哪张表里
	 */
	public String findNameByUid(String uid,String utype);
/**
 * 更具id和type 即id和所在的表 查看其的state否在职  离职则登不进去
 * @param uid
 * @param utype
 * @return
 */
	public boolean findeStateByUid(String uid, String utype);
}
