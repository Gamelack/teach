package com.user.bean;

import java.io.Serializable;
import java.util.Date;

public class HT_User implements Serializable{
	private Integer id;
	private String username;
	private String password;
	private Date registDate;
	private Integer deptno;
	private Integer roleId;
	public HT_User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HT_User(Integer id, String username, String password,
			Date registDate, Integer deptno, Integer roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.registDate = registDate;
		this.deptno = deptno;
		this.roleId = roleId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "HT_User [id=" + id + ", username=" + username + ", password="
				+ password + ", registDate=" + registDate + ", deptno="
				+ deptno + ", roleId=" + roleId + "]";
	}
	
}