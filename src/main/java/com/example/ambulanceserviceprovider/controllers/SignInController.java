package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.HelloApplication;
import com.example.ambulanceserviceprovider.datatypes.*;
import com.example.ambulanceserviceprovider.models.UserModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
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

	public void clickRegisterButton (ActionEvent event) throws IOException {
		Parent signUpParent = FXMLLoader.load(HelloApplication.class.getResource("signup.fxml"));
		Scene signUpScene = new Scene(signUpParent);

		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(signUpScene);
		window.show();
	}
}
