package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.UserType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserTypeModel {
	public UserType getUserType (String name) throws SQLException {
		UserType userType = new UserType();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM usertype WHERE usertype_name = %s".formatted(name);

			ResultSet result = con.prepareStatement(statement).executeQuery();

			if (!result.next()) {
				return null;
			}

			userType.setId(result.getInt("usertype_id"));
			userType.setUserType(result.getString("usertype_name"));
		}

		return userType;
	}

	public List<UserType> getAllUserTypes () throws SQLException {
		List<UserType> userTypes = new ArrayList<>();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM usertype";

			ResultSet result = con.prepareStatement(statement).executeQuery();

			while (result.next()) {
				UserType userType = new UserType();

				userType.setId(result.getInt("usertype_id"));
				userType.setUserType(result.getString("usertype_name"));

				userTypes.add(userType);
			}
		}

		return userTypes;
	}
}
