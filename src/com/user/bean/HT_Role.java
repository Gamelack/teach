package com.user.bean;

import java.io.Serializable;


public class HT_Role  implements Serializable{
	private Integer id;
	private String name;
	public HT_Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HT_Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "HT_Role [id=" + id + ", name=" + name + "]";
	}
	
}