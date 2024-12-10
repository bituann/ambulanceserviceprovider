package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.datatypes.*;
import com.example.ambulanceserviceprovider.models.UserModel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Objects;

public class SignInController {
	@FXML
	private TextField signInEmail;
	private final UserModel userModel = new UserModel();

	public void signIn () {
		String email = signInEmail.getText();

		try {
			User user = userModel.getUser(email);

			if (Objects.equals(user.getEmail(), email)) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
