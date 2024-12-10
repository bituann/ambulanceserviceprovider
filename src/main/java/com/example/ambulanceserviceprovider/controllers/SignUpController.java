package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.HelloApplication;
import com.example.ambulanceserviceprovider.datatypes.UserType;
import com.example.ambulanceserviceprovider.models.UserTypeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

	@FXML
	private ComboBox<String> userType;

	@Override
	public void initialize (URL url, ResourceBundle rb) {
		try {
			List<UserType> userTypes = new UserTypeModel().getAllUserTypes();

			ObservableList observableList = FXCollections.observableArrayList();

			for (UserType uT : userTypes) {
				observableList.add(uT.getUserType());
			}

			userType.setItems(observableList);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

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
