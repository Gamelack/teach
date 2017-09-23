package com.user.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBFactory {

	private static Connection connection;

	public static Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				init();// 如果连接为null或者已经关闭，那么初始化
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private static void init() {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String name = "libai3";
		String password = "123";
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, name, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close(Connection connection) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement statement) {
		try {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, Statement statement,
			ResultSet resultSet) {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (resultSet != null && !resultSet.isClosed()) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
