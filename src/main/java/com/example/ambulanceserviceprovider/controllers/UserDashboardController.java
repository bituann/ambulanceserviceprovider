package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.HelloApplication;
import com.example.ambulanceserviceprovider.datatypes.User;
import com.example.ambulanceserviceprovider.models.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class UserDashboardController {
	private User user;

	@FXML
	private Label userName;

	@FXML
	private Label userEmail;

	public void setUserName(String name) {
		userName.setText(name);
	}

	public void setUserEmail(String email) {
		userEmail.setText(email);
	}

	public void logOut(ActionEvent event) throws IOException {
		Parent signInParent = FXMLLoader.load(HelloApplication.class.getResource("signin.fxml"));

		changeScene(signInParent, event);
	}

	private void changeScene (Parent parent, ActionEvent event) throws IOException {
		Scene signUpScene = new Scene(parent);

		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(signUpScene);
		window.show();
	}
}
