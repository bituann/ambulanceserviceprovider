package com.example.ambulanceserviceprovider.datatypes;

public class User {
	private int id;
	private String name;
	private String phoneNum;
	private String email;
	private int type;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public int getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setType(int type) {
		this.type = type;
	}
}
