package com.example.ambulanceserviceprovider.models;

import com.example.ambulanceserviceprovider.datatypes.Notification;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotificationModel {
	public Notification getNotification (int id) throws SQLException {
		Notification notification = new Notification();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM notification WHERE notif_id = %d".formatted(id);
			ResultSet result = con.prepareStatement(statement).executeQuery();

			result.next();

			notification.setId(result.getInt("notif_id"));
			notification.setUserId(result.getInt("notif_userid"));
			notification.setTitle(result.getString("notif_title"));
		}

		return notification;
	}

	public List<Notification> getAllUserNotifications (int userId) throws SQLException {
		List<Notification> notifications = new ArrayList<>();

		try (Connection con = DBModel.getDBConnection()) {
			String statement = "SELECT * FROM notification WHERE notif_userid = %d".formatted(userId);

			ResultSet result = con.prepareStatement(statement).executeQuery();

			while (result.next()) {
				Notification notification = new Notification();
				notification.setId(result.getInt("notif_id"));
				notification.setUserId(result.getInt("notif_userid"));
				notification.setTitle(result.getString("notif_title"));

				notifications.add(notification);
			}
		}

		return notifications;
	}
}
