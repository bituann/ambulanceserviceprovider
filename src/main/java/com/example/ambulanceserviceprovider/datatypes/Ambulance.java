package com.example.ambulanceserviceprovider.datatypes;

public class Ambulance {
	private int id;
	private String platenum;
	private int status;

	public int getId() {
		return id;
	}

	public String getPlatenum() {
		return platenum;
	}

	public int getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPlatenum(String platenum) {
		this.platenum = platenum;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
