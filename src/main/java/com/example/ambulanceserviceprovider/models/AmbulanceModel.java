package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Ambulance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AmbulanceModel {
	public Ambulance getAmbulance(int ambId) throws SQLException {
		Ambulance ambulance = new Ambulance();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM ambulance WHERE amb_id = %d".formatted(ambId);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			ambulance.setId(result.getInt("amb_id"));
			ambulance.setPlatenum(result.getString("amb_platenum"));
			ambulance.setStatus(result.getInt("amb_status"));
		}

		return ambulance;
	}
}
