package com.example.ambulanceserviceprovider.datatypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class AssignedEmergency {
	private int id;
	private int emergencyId;
	private int ambulanceId;
	private int personnelGroupId;
	private int status;
	private LocalDate date;
	private LocalTime time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmergencyId() {
		return emergencyId;
	}

	public void setEmergencyId(int emergencyId) {
		this.emergencyId = emergencyId;
	}

	public int getAmbulanceId() {
		return ambulanceId;
	}

	public void setAmbulanceId(int ambulanceId) {
		this.ambulanceId = ambulanceId;
	}

	public int getPersonnelGroupId() {
		return personnelGroupId;
	}

	public void setPersonnelGroupId(int personnelGroupId) {
		this.personnelGroupId = personnelGroupId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
}
