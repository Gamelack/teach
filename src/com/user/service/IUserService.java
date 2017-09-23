package com.user.service;

import java.util.Date;
import java.util.List;

import com.user.bean.UserInfo;

/**
 * 
 * @author Administrator
 *
 */
public interface IUserService {
	boolean hasUser(String username);
	boolean regist(String username,String password,String sex,Date registDate,int right_id);
	UserInfo login(String username,String password);
	List<UserInfo> getAllUserInfo();
	UserInfo getUserById(int id);
	boolean deleteUserById(int id);
	boolean updateUserById(int id,String username,String password,String sex,Date registDate,int right_id);
}
