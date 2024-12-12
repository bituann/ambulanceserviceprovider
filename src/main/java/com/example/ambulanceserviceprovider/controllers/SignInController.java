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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignInController {
	@FXML
	private TextField signInEmail;
	private final UserModel userModel = new UserModel();

	public void signIn (ActionEvent event) throws IOException {
		String email = signInEmail.getText();

		try {
			User user = userModel.getUser(email);

			if (user != null) {
				FXMLLoader dashboardLoader = new FXMLLoader(HelloApplication.class.getResource("userdashboard.fxml"));
				Parent dashboardParent = dashboardLoader.load();

//				To pass the email & name to the user dashboard page
				UserDashboardController dashboardController = dashboardLoader.getController();
				dashboardController.setUserEmail(email);
				dashboardController.setUserName(userModel.getUser(email).getName());

//				Load dashboard
				Scene signUpScene = new Scene(dashboardParent);
				Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
				window.setScene(signUpScene);
				window.show();

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
