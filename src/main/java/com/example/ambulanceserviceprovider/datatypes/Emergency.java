package com.example.ambulanceserviceprovider.datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class Emergency {
	private int id;
	private String title;
	private String desc;
	private LocalDate date;
	private String location;
	private LocalTime time;
	private int userId;

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

	public LocalTime getTime() {
		return time;
	}

	public int getUserId() {
		return userId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
