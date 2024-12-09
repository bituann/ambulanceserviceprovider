package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Notification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotificationModel {
	public Notification getNotification (int id) throws SQLException {
		Notification notification = new Notification();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * from notification where id=%d".formatted(id);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			notification.setId(result.getInt("notif_id"));
			notification.setUserId(result.getInt("notif_userid"));
			notification.setTitle(result.getString("notif_title"));
		}

		return notification;
	}
}
