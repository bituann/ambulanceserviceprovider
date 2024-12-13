package com.example.ambulanceserviceprovider;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ambex extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(Ambex.class.getResource("signin.fxml"));
		Scene scene = new Scene(fxmlLoader.load());
		stage.setTitle("Ambex Ambulance Service");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}