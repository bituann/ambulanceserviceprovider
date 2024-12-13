package com.example.ambulanceserviceprovider.controllers;

import com.example.ambulanceserviceprovider.Ambex;
import com.example.ambulanceserviceprovider.datatypes.UserType;
import com.example.ambulanceserviceprovider.models.UserModel;
import com.example.ambulanceserviceprovider.models.UserTypeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

	@FXML
	private ComboBox<String> userType;

	@FXML
	private TextField signUpName;

	@FXML
	private TextField signUpPhoneNum;

	@FXML
	private TextField signUpEmail;

	@FXML
	private BorderPane basePane;

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

	public void goBackButton() throws IOException {
		Parent signUpParent = FXMLLoader.load(Ambex.class.getResource("signin.fxml"));

		basePane.getChildren().clear();
		basePane.setCenter(signUpParent);
	}

	public void registerUserButton (ActionEvent event) throws IOException, SQLException {
		String name = signUpName.getText();
		String phoneNum = signUpPhoneNum.getText();
		String email = signUpEmail.getText();
		int uT = userType.getSelectionModel().getSelectedIndex();

		try {
			new UserModel().addUser(name, email, phoneNum, uT+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		FXMLLoader dashboardLoader = new FXMLLoader(Ambex.class.getResource("userdashboard.fxml"));
		Parent dashboardParent = dashboardLoader.load();

		UserDashboardController dashboardController = dashboardLoader.getController();
		dashboardController.setUserName(new UserModel().getUser(email).getName());
		dashboardController.setUserEmail(email);

		basePane.getChildren().clear();
		basePane.setCenter(dashboardParent);
	}
}
