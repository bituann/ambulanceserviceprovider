package com.example.ambulanceserviceprovider.datatypes;

public class PersonnelGroup {
	private int id;
	private int doctorId;
	private int attendeeOneId;
	private int attendeeTwoId;
	private int driverId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getAttendeeOneId() {
		return attendeeOneId;
	}

	public void setAttendeeOneId(int attendeeOneId) {
		this.attendeeOneId = attendeeOneId;
	}

	public int getAttendeeTwoId() {
		return attendeeTwoId;
	}

	public void setAttendeeTwoId(int attendeeTwoId) {
		this.attendeeTwoId = attendeeTwoId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
}
