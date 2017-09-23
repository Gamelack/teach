package com.user.dao;

import java.util.Date;
import java.util.List;

import com.user.bean.HT_User;

/**
 * 用户操作：增、删、改、查
 * @author Administrator
 *
 */
public interface IUserDao {
	/**
	 * 查询所有用户
	 * @return
	 */
	List<HT_User> getAllUsers();
	/**
	 * 添加一个用户
	 * @param user
	 * @return	影响的行数
	 */
	boolean addUser(HT_User user);
	/**
	 * 删除用户
	 * @param userId
	 * @return 删除德用户的条数
	 */
	boolean delteUserById(int userId);
	/**
	 * 根据id获取用户
	 * @param userId
	 * @return
	 */
	HT_User getUserById(int userId);
	/**
	 * 根据用户名查询用户：建议不要把所有信息都获取到
	 * @param username
	 * @return	用户信息，用户信息可以不全
	 */
	HT_User getUserByName(String username);
	/**
	 * 根据用户名、密码查询用户
	 * @param username
	 * @param password
	 * @return	所有用户信息
	 */
	HT_User getUserByNameAndPassword(String username,String password);

	boolean updateUser(int id,String username,String password,String sex,Date registDate,int right_id);
}


