package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.PersonnelGroup;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelGroupModel {
	public PersonnelGroup getPersonnelGroup(int id) throws SQLException {
		PersonnelGroup personnelGroup = new PersonnelGroup();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM personnelgroup WHERE persgroup_id = %d".formatted(id);

			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			personnelGroup.setId(result.getInt("persgroup_id"));
			personnelGroup.setDoctorId(result.getInt("persgroup_doctor"));
			personnelGroup.setAttendeeOneId(result.getInt("persgroup_attendeeone"));
			personnelGroup.setAttendeeTwoId(result.getInt("persgroup_attendeetwo"));
			personnelGroup.setDriverId(result.getInt("persgroup_driver"));
		}

		return personnelGroup;
	}

	public void addPersonnelGroup(int doctorId, int attendeeOneId, int attendeeTwoId, int driverId) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "INSERT INTO personnelgroup (persgroup_doctor, persgroup_attendeeone, persgroup_attendeetwo, persgroup_driver" +
					"VALUES (%d, %d, %d, %d)".formatted(doctorId, attendeeOneId, attendeeTwoId, driverId);

			con.prepareStatement(statement).execute();
		}
	}
}
