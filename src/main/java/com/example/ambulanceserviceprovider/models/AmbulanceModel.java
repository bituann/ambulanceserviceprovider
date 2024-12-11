package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Ambulance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AmbulanceModel {
	public Ambulance getAmbulance(int ambId) throws SQLException {
		Ambulance ambulance = new Ambulance();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM ambulance WHERE amb_id = %d".formatted(ambId);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			if (!result.next()) {
				return null;
			}

			ambulance.setId(result.getInt("amb_id"));
			ambulance.setPlatenum(result.getString("amb_platenum"));
			ambulance.setStatus(result.getInt("amb_status"));
		}

		return ambulance;
	}

	public void addAmbulance(int id, String plateNum, int status) throws  SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "INSERT INTO ambulance (amb_id, amb_platenum, amb_status) VALUES (?, ?, ?)";

			PreparedStatement preparedStatement = con.prepareStatement(statement);

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, plateNum);
			preparedStatement.setInt(3, status);

			preparedStatement.execute();
		}
	}

	public  void deleteAmbulance(int ambId) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "DELETE FROM ambulance WHERE amb_id = ?";

			PreparedStatement preparedStatement = con.prepareStatement(statement);

			preparedStatement.setInt(1, ambId);

			preparedStatement.execute();
		}
	}

	public  void deleteAmbulance(String plateNum) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "DELETE FROM ambulance WHERE amb_platenum = ?";

			PreparedStatement preparedStatement = con.prepareStatement(statement);

			preparedStatement.setString(1, plateNum);

			preparedStatement.execute();
		}
	}
}
