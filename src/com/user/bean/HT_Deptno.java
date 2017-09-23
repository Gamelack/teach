package com.user.bean;

import java.io.Serializable;


public class HT_Deptno implements Serializable{
	private Integer id;
	private String name;
	private String address;
	public HT_Deptno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HT_Deptno(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "HT_Deptno [id=" + id + ", name=" + name + ", address="
				+ address + "]";
	}
	
}