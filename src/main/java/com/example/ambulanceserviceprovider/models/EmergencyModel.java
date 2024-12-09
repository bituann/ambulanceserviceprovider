package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Emergency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmergencyModel {
	public Emergency getEmergency(int id) throws SQLException {
		Emergency emergency = new Emergency();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM emergency WHERE emer_id = %d".formatted(id);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			emergency.setId(result.getInt("emer_id"));
			emergency.setTitle(result.getString("emer_title"));
			emergency.setDesc(result.getString("emer_desc"));
			emergency.setDate(result.getDate("emer_date").toLocalDate());
			emergency.setLocation(result.getString("emer_desc"));
			emergency.setTime(result.getTime("emer_timereported").toLocalTime());
		}

		return emergency;
	}
}
