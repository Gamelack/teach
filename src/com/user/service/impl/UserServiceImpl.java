package com.user.service.impl;

import java.util.Date;
import java.util.List;

import com.user.bean.UserInfo;
import com.user.dao.IUserDao;
import com.user.dao.impl.UserDaoImpl;
import com.user.service.IUserService;

public class UserServiceImpl implements IUserService{

	@Override
	public boolean hasUser(String username) {
		IUserDao iUser = new UserDaoImpl();
		UserInfo userInfo = iUser.getUserByName(username);
		return userInfo!=null;
	}

	@Override
	public boolean regist(String username, String password, String sex,
			Date registDate, int right_id) {
		//如果没有这个用户，那么，可以注册
		if(hasUser(username)){
			return false;
		}else{
			IUserDao iUser = new UserDaoImpl();
			//java.util.Date与java.sql.Date
			UserInfo user = new UserInfo(1, username, password, sex, registDate, right_id, null);
			iUser.addUser(user );
			return true;
		}
	}

	@Override
	public UserInfo login(String username, String password) {
		IUserDao iUser  =new UserDaoImpl();
		UserInfo info = iUser.getUserByNameAndPassword(username, password);
		//info=null;那么，info!=null
		return info;
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		IUserDao iUser  =new UserDaoImpl();
		return  iUser.getAllUsers();
	}

	@Override
	public UserInfo getUserById(int id) {
		IUserDao iUser  =new UserDaoImpl();
		return  iUser.getUserById(id);
	}

	@Override
	public boolean deleteUserById(int id) {
		IUserDao iUser  =new UserDaoImpl();
		return  iUser.delteUserById(id);
	}

	@Override
	public boolean updateUserById(int id, String username, String password,
			String sex, Date registDate, int right_id) {
		IUserDao iUser  =new UserDaoImpl();
		return  iUser.updateUser(id, username, password, sex, registDate, right_id);
	}

}
