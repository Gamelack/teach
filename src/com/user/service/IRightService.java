package com.user.service;

import java.util.List;
import java.util.Map;

import com.user.bean.UserRight;

public interface IRightService {
	public Map<Integer,String> getAllRight();
	public List<UserRight> getAllRightList();
}
