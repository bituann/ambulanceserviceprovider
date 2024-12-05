package com.example.ambulanceserviceprovider.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
	public User getUser(String email) throws SQLException {
		User user;
		String statement = "SELECT * from appuser WHERE email = %s".formatted(email);

		try (Connection con = DBModel.getDBConnection()) {
			ResultSet result = con.prepareStatement(statement).executeQuery();

			user = new User();

			user.setId(result.getInt("id"));
			user.setName(result.getString("name"));
			user.setEmail(result.getString("email"));
			user.setPhoneNo(result.getString("phonenumber"));
			user.setType(result.getString("type"));
		} catch (SQLException e) {
			throw e;
		}

		return user;
	}
}

class User {
	private int id;
	private String name;
	private String phoneNo;
	private String email;
	private String type;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setType(String type) {
		this.type = type;
	}
}
