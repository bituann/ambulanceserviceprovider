package com.example.ambulanceserviceprovider.models;

import java.sql.*;

public class DBModel {
	public static Connection getDBConnection () throws SQLException {
		final String username = "";
		final String password = "";
		final String url = "jdbc:postgresql://localhost:5432/ambex";

		return DriverManager.getConnection(url, username, password);
	}
}
