package com.example.ambulanceserviceprovider.datatypes;

public class Notification {
	private int id;
	private int userId;
	private String title;

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public String getTitle() {
		return title;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
