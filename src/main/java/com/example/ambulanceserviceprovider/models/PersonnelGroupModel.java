package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.PersonnelGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelGroupModel {
	public PersonnelGroup getPersonnelGroup(int id) throws SQLException {
		PersonnelGroup personnelGroup = new PersonnelGroup();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM personnelgroup WHERE persgroup_id = %d".formatted(id);

			ResultSet result = con.prepareStatement(statement).executeQuery();

			if (!result.next()) {
				return null;
			}

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
					"VALUES (?, ?, ?, ?)";

			PreparedStatement preparedStatement = con.prepareStatement(statement);

			preparedStatement.setInt(1, doctorId);
			preparedStatement.setInt(2, attendeeOneId);
			preparedStatement.setInt(3, attendeeTwoId);
			preparedStatement.setInt(4, driverId);

			preparedStatement.execute();
		}
	}
}
