package com.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.user.bean.UserInfo;
import com.user.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	@Override
	public List<UserInfo> getAllUsers() {
		Connection connection = DBFactory.getConnection();
		String sql = "select id,username,password,sex,registDate,right_id from user_info";
		PreparedStatement pre = null;
		ResultSet rs = null;
		List<UserInfo> list = new ArrayList<UserInfo>();

		try {
			pre = connection.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String sex = rs.getString(4);
				Date registDate = rs.getDate(5);
				Integer right_id = rs.getInt(6);
				UserInfo info = new UserInfo(id, username, password, sex,
						registDate, right_id, null);
				// System.out.println(info);
				list.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBFactory.close(connection, pre, rs);
		}
		return list;
	}

	@Override
	public boolean addUser(UserInfo user) {
		Connection connection = DBFactory.getConnection();
		String sql = "insert into user_info(username,password,sex,registDate,right_id) values(?,?,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, user.getUsername());
			pre.setObject(2, user.getPassword());
			pre.setObject(3, user.getSex());
			//日期的转换——一定掌握
			pre.setObject(4, new java.sql.Date(user.getRegistDate().getTime()));
			// 用户正常注册，那么默认在服务代码中应给设定为2，如果是管理员添加的用户，就是管理员设定的权限
			pre.setObject(5, user.getRight_id());// 应该在服务那边给上
			/*
			 * true if the first result is a ResultSet object; false if the
			 * first result is an update count or there is no result
			 */
			boolean b = pre.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;// 出现异常，证明没有添加
		} finally {
			DBFactory.close(connection, pre, null);
		}
		return true;
	}

	@Override
	public boolean delteUserById(int userId) {
		Connection connection = DBFactory.getConnection();
		String sql = "delete from  user_info where id=?";
		PreparedStatement pre = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, userId);
			pre.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;// 出现异常，证明没有添加
		} finally {
			DBFactory.close(connection, pre, null);
		}
		return true;
	}

	@Override
	public UserInfo getUserById(int userId) {
		Connection connection = DBFactory.getConnection();
		String sql = "select id,username,password,sex,registDate,right_id from user_info where id=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, userId);
			rs = pre.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String sex = rs.getString(4);
				Date registDate = rs.getDate(5);
				Integer right_id = rs.getInt(6);
				UserInfo info = new UserInfo(id, username, password, sex,
						registDate, right_id, null);
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBFactory.close(connection, pre, rs);
		}
		return null;
	}

	@Override
	public UserInfo getUserByName(String username) {
		Connection connection = DBFactory.getConnection();
		String sql = "select id,username,password,sex,registDate,right_id from user_info where username=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, username);
			rs = pre.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				username = rs.getString(2);
				String password = rs.getString(3);
				String sex = rs.getString(4);
				Date registDate = rs.getDate(5);
				Integer right_id = rs.getInt(6);
				UserInfo info = new UserInfo(id, username, password, sex,
						registDate, right_id, null);
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBFactory.close(connection, pre, rs);
		}
		return null;
	}

	@Override
	public UserInfo getUserByNameAndPassword(String username, String password) {
		Connection connection = DBFactory.getConnection();
		String sql = "select id,username,password,sex,registDate,right_id from user_info where username=? and password=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, username);
			pre.setObject(2, password);
			rs = pre.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				username = rs.getString(2);
				password = rs.getString(3);
				String sex = rs.getString(4);
				Date registDate = rs.getDate(5);
				Integer right_id = rs.getInt(6);
				UserInfo info = new UserInfo(id, username, password, sex,
						registDate, right_id, null);
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBFactory.close(connection, pre, rs);
		}
		return null;
	}

	

	@Override
	public boolean updateUser(int id, String username, String password,
			String sex, Date registDate, int right_id) {
		Connection connection = DBFactory.getConnection();
		String sql = "update user_info set username=? , password=? , sex=? , registDate=? , right_id=? where id=?";
		PreparedStatement pre = null;
		ResultSet rs = null;
		try {
			pre = connection.prepareStatement(sql);
			pre.setObject(1, username);
			pre.setObject(2, password);
			pre.setObject(3, sex);
			pre.setObject(4, new java.sql.Date(registDate.getTime()));
			pre.setObject(5, right_id);
			pre.setObject(6, id);
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBFactory.close(connection, pre, rs);
		}
		return true;
	}
}
