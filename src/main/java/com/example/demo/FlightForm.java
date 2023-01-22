package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FlightForm extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setSpacing(10);

        HBox destinationRow = new HBox();
        destinationRow.setSpacing(10);
        destinationRow.setPrefWidth(30);
        Label destinationLabel = new Label("Destination:");
        TextField destinationField = new TextField();
        destinationRow.getChildren().addAll(destinationLabel, destinationField);
        root.getChildren().add(destinationRow);

        HBox flightDateRow = new HBox();
        flightDateRow.setSpacing(10);
        Label flightDateLabel = new Label("Flight Date:");
        DatePicker flightDatePicker = new DatePicker();
        flightDateRow.getChildren().addAll(flightDateLabel, flightDatePicker);
        root.getChildren().add(flightDateRow);

        HBox numSeatsRow = new HBox();
        numSeatsRow.setSpacing(10);
        Label numSeatsLabel = new Label("Number of Seats:");
        TextField numSeatsField = new TextField();
        numSeatsRow.getChildren().addAll(numSeatsLabel, numSeatsField);
        root.getChildren().add(numSeatsRow);

        HBox priceRow = new HBox();
        priceRow.setSpacing(10);
        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();
        priceRow.getChildren().addAll(priceLabel, priceField);
        root.getChildren().add(priceRow);

        HBox submitRow = new HBox();
        submitRow.setSpacing(10);
        Button submitButton = new Button("Submit");
        submitRow.getChildren().add(submitButton);
        root.getChildren().add(submitRow);

        HBox idRow = new HBox();
        idRow.setSpacing(10);
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();
        idRow.getChildren().addAll(idLabel, idField);
        root.getChildren().add(idRow);

        HBox deleteRow = new HBox();
        submitRow.setSpacing(10);
        Button deleteButton = new Button("Delete");
        deleteRow.getChildren().add(deleteButton);
        root.getChildren().add(deleteButton);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Flight Form");
        primaryStage.setScene(scene);
        primaryStage.show();
        FlightFormController controller = new FlightFormController(destinationField, flightDatePicker, numSeatsField, priceField, submitButton, deleteButton, idField);
    }

    public static void main(String[] args) {
        launch(args);
    }
}