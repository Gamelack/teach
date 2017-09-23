package com.user.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.user.bean.UserRight;
import com.user.dao.IRightDao;

public class RightDaoImpl implements IRightDao {

	@Override
	public Map<Integer, String> getAllRight() {
		Connection connection = DBFactory.getConnection();
		Statement statement = null;
		ResultSet rs = null;
		Map<Integer,String> map = new HashMap<Integer, String>();
		try {
			statement = connection.createStatement();
			String sql  ="select id,name from user_right";
			 rs = statement.executeQuery(sql);
			 while (rs.next()) {
				 Integer id = rs.getInt(1);
				 String name = rs.getString(2);
				 map.put(id, name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBFactory.close(connection, statement, rs);
		}
		return map;
	}

	@Override
	public List<UserRight> getAllRightList() {
		Connection connection = DBFactory.getConnection();
		Statement statement = null;
		ResultSet rs = null;
		List<UserRight> list =new ArrayList<UserRight>();
		try {
			statement = connection.createStatement();
			String sql  ="select id,name from user_right";
			 rs = statement.executeQuery(sql);
			 while (rs.next()) {
				 Integer id = rs.getInt(1);
				 String name = rs.getString(2);
				list.add(new UserRight(id, name));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBFactory.close(connection, statement, rs);
		}
		return list;
	}

}
