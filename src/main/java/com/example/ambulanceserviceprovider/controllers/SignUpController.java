package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
	public void goBackButton(ActionEvent event) throws IOException {
		Parent signUpParent = FXMLLoader.load(HelloApplication.class.getResource("signin.fxml"));
		Scene signUpScene = new Scene(signUpParent);

		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(signUpScene);
		window.show();
	}

	public void registerUserButton () {

	}
}
