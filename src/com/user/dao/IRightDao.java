package com.user.dao;

import java.util.List;

import com.user.bean.HT_Right;

public interface IRightDao {
	/**
	 * 获取所有权限
	 * @return 权限集合
	 */
	List<HT_Right> getAllRightList();
	/**
	 * 添加权限
	 * id通过序列自动增长
	 * @param name 权限名
	 */
	void addRight(String name);
	void updateRight(Integer id,String name);
}
