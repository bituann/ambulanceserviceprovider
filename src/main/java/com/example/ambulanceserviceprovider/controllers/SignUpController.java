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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
		Parent signUpParent = FXMLLoader.load(Ambex.class.getResource("signin.fxml"));
		changeScene(signUpParent, event);
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

		changeScene(dashboardParent, event);
	}

	private void changeScene (Parent parent, ActionEvent event) throws IOException {
		Scene signUpScene = new Scene(parent);

		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(signUpScene);
		window.show();
	}
}
