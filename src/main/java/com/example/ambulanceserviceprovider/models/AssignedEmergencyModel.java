package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.AssignedEmergency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignedEmergencyModel {
	public AssignedEmergency getAssignedEmergency (int id) throws SQLException {
		AssignedEmergency assignedEmergency = new AssignedEmergency();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM assignedemergency WHERE assemer_emergencyid = %d".formatted(id);

			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			assignedEmergency.setId(result.getInt("assemer_id"));
			assignedEmergency.setEmergencyId(result.getInt("assemer_emergencyid"));
			assignedEmergency.setAmbulanceId(result.getInt("assemer_ambulanceid"));
			assignedEmergency.setPersonnelGroupId(result.getInt("assemer_personnelgroupid"));
			assignedEmergency.setStatus(result.getInt("assemer_status"));
			assignedEmergency.setDate(result.getDate("assemer_datehandled").toLocalDate());
			assignedEmergency.setTime(result.getTime("assemer_timehandled").toLocalTime());
		}

		return assignedEmergency;
	}

	public List<AssignedEmergency> getAllAssignedEmergency () throws SQLException {
		List<AssignedEmergency> assignedEmergencies = new ArrayList<>();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM assignedemergency";

			ResultSet result = con.prepareStatement(statement).executeQuery();

			while(result.next()) {
				AssignedEmergency assignedEmergency = new AssignedEmergency();

				assignedEmergency.setId(result.getInt("assemer_id"));
				assignedEmergency.setEmergencyId(result.getInt("assemer_emergencyid"));
				assignedEmergency.setAmbulanceId(result.getInt("assemer_ambulanceid"));
				assignedEmergency.setPersonnelGroupId(result.getInt("assemer_personnelgroupid"));
				assignedEmergency.setStatus(result.getInt("assemer_status"));
				assignedEmergency.setDate(result.getDate("assemer_datehandled").toLocalDate());
				assignedEmergency.setTime(result.getTime("assemer_timehandled").toLocalTime());

				assignedEmergencies.add(assignedEmergency);
			}
		}

		return assignedEmergencies;
	}
}
