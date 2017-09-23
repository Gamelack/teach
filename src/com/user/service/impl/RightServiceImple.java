package com.user.service.impl;

import java.util.List;
import java.util.Map;

import com.user.bean.UserRight;
import com.user.dao.IRightDao;
import com.user.dao.impl.RightDaoImpl;
import com.user.service.IRightService;

public class RightServiceImple implements IRightService{

	/**
	 * 获取所有权限
	 * @param Map<Integer,String> key-权限id		value-权限名称
	 */
	@Override
	public Map<Integer, String> getAllRight() {
		IRightDao dao = new RightDaoImpl();
		return dao.getAllRight(); 
	}

	@Override
	public List<UserRight> getAllRightList() {
		IRightDao dao = new RightDaoImpl();
		return dao.getAllRightList(); 
	}
	
}
