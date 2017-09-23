package com.user.bean;

import java.io.Serializable;
import java.util.Date;

public class HT_Right implements Serializable{
	private Integer id;
	private String name;
	private String rightIDS;
	public HT_Right() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HT_Right(Integer id, String name, String rightIDS) {
		super();
		this.id = id;
		this.name = name;
		this.rightIDS = rightIDS;
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
	public String getRightIDS() {
		return rightIDS;
	}
	public void setRightIDS(String rightIDS) {
		this.rightIDS = rightIDS;
	}
	@Override
	public String toString() {
		return "HT_Right [id=" + id + ", name=" + name + ", rightIDS="
				+ rightIDS + "]";
	}
	
}