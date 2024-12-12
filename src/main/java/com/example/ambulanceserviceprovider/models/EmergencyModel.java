package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Emergency;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EmergencyModel {
	public Emergency getEmergency(int id) throws SQLException {
		Emergency emergency = new Emergency();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM emergency WHERE emer_id = %d".formatted(id);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			if (!result.next()) {
				return null;
			}

			emergency.setId(result.getInt("emer_id"));
			emergency.setTitle(result.getString("emer_title"));
			emergency.setDesc(result.getString("emer_desc"));
			emergency.setDate(result.getDate("emer_date").toLocalDate());
			emergency.setLocation(result.getString("emer_desc"));
			emergency.setTime(result.getTime("emer_timereported").toLocalTime());
			emergency.setUserId(result.getInt("emer_userid"));
		}

		return emergency;
	}

	public List<Emergency> getAllEmergency () throws SQLException {
		List<Emergency> emergencies = new ArrayList<>();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM emergency";
			ResultSet result = con.prepareStatement(statement).executeQuery();

			while (result.next()) {
				Emergency emergency = new Emergency();

				emergency.setId(result.getInt("emer_id"));
				emergency.setTitle(result.getString("emer_title"));
				emergency.setDesc(result.getString("emer_desc"));
				emergency.setDate(result.getDate("emer_date").toLocalDate());
				emergency.setLocation(result.getString("emer_desc"));
				emergency.setTime(result.getTime("emer_timereported").toLocalTime());
				emergency.setUserId(result.getInt("emer_userid"));

				emergencies.add(emergency);
			}
		}

		if (emergencies.isEmpty()) {
			return null;
		}

		return emergencies;
	}

	public void addEmergency (String title, String desc, String location, LocalDate date, LocalTime time, int userId) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "INSERT INTO emergency (emer_title, emer_desc, emer_location, emer_date, emer_timereported, emer_userid)" +
					"VALUES (?, ?, ?, ?, ?, ?)".formatted(title, desc, location, userId);

			PreparedStatement preparedStatement = con.prepareStatement(statement);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, desc);
			preparedStatement.setString(3, location);
			preparedStatement.setObject(4, date);
			preparedStatement.setObject(5, time);
			preparedStatement.setInt(6, userId);

			preparedStatement.execute();
		}
	}
}
