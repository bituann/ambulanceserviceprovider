package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.Ambex;
import com.example.ambulanceserviceprovider.datatypes.User;
import com.example.ambulanceserviceprovider.models.EmergencyModel;
import com.example.ambulanceserviceprovider.models.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;


public class UserDashboardController {
	private final UserModel userModel = new UserModel();
	private final EmergencyModel emergencyModel = new EmergencyModel();

	@FXML
	private Label userName;

	@FXML
	private Label userEmail;

	@FXML
	private TextField requestTitle;

	@FXML
	private TextField requestDesc;

	@FXML
	private TextField requestLocation;

	@FXML
	private TextField requestOutcomeMessage;

	public void setUserName(String name) {
		userName.setText(name);
	}

	public void setUserEmail(String email) {
		userEmail.setText(email);
	}

	public void logOut(ActionEvent event) throws IOException {
		Parent signInParent = FXMLLoader.load(Ambex.class.getResource("signin.fxml"));

		changeScene(signInParent, event);
	}

	public void requestAmbulanceButton() throws SQLException {
		String email = userEmail.getText();

		String title = requestTitle.getText();
		String desc = requestDesc.getText();
		String location = requestLocation.getText();
		User user = userModel.getUser(email);

		emergencyModel.addEmergency(title, desc, location, LocalDate.now(), LocalTime.now(), user.getId());

		requestOutcomeMessage.setText("Success! \n An ambulance will be with you shortly!");

		requestTitle.clear();
		requestDesc.clear();
		requestLocation.clear();
	}

	private void changeScene (Parent parent, ActionEvent event) throws IOException {
		Scene signUpScene = new Scene(parent);

		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(signUpScene);
		window.show();
	}
}
