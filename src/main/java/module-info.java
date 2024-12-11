module com.example.ambulanceserviceprovider {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;

	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires net.synedra.validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;
	requires eu.hansolo.tilesfx;
	requires java.sql;

	opens com.example.ambulanceserviceprovider to javafx.fxml;
	opens com.example.ambulanceserviceprovider.controllers to javafx.fxml;
	exports com.example.ambulanceserviceprovider;
}