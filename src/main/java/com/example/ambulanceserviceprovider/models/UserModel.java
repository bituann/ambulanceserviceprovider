package com.example.ambulanceserviceprovider.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	private List<String> usertype;

	public User getUser(String email) throws SQLException {
		User user;

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * from appuser WHERE user_email = '%s'".formatted(email);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			user = new User();

			user.setId(result.getInt("user_id"));
			user.setName(result.getString("user_name"));
			user.setEmail(result.getString("user_email"));
			user.setPhoneNum(result.getString("user_phonenum"));
			user.setType(result.getInt("user_type"));
		}

		return user;
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> users = new ArrayList<>();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM appuser";
			ResultSet userResult = con.prepareStatement(statement).executeQuery();

			while (userResult.next()) {
				User user = new User();
				user.setId(userResult.getInt("user_id"));
				user.setName(userResult.getString("user_name"));
				user.setEmail(userResult.getString("user_email"));
				user.setPhoneNum(userResult.getString("user_phonenum"));
				user.setType(userResult.getInt("user_type"));

				users.add(user);
			}
		}

		return users;
	}

	public void addUser (String name, String email, String phoneno, int type) throws SQLException {
		try (Connection con = DBModel.getDBConnection()) {
			String statement = "INSERT INTO appuser (user_name, user_email, user_phonenum, user_type) VALUES (%s, %s, %s, %d)".formatted(name, email, phoneno, type);

			con.prepareStatement(statement).execute();
		}
	}
}

class User {
	private int id;
	private String name;
	private String phoneNum;
	private String email;
	private int type;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public int getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setType(int type) {
		this.type = type;
	}
}
