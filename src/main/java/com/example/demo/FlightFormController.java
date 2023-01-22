package com.example.demo;

import javafx.scene.control.*;

import java.util.Date;

public class FlightFormController {

    private TextField destinationField;
    private DatePicker flightDatePicker;
    private TextField numSeatsField;
    private TextField priceField;
    private Button submitButton;

    private TextField idField;
    private Button deleteButton;
    private MySQLDatabase db;

    public FlightFormController(TextField destinationField, DatePicker flightDatePicker, TextField numSeatsField, TextField priceField, Button submitButton, Button deleteButton, TextField idField) {
        this.destinationField = destinationField;
        this.flightDatePicker = flightDatePicker;
        this.numSeatsField = numSeatsField;
        this.priceField = priceField;
        this.submitButton = submitButton;
        this.deleteButton = deleteButton;
        this.idField = idField;
        db = new MySQLDatabase();
        addSubmitButtonEvent();
        addDeleteButtonEvent();
    }

    private void addSubmitButtonEvent() {
        submitButton.setOnAction(event -> {
            String destination = destinationField.getText();
            Date flightDate = java.sql.Date.valueOf(flightDatePicker.getValue());
            int numSeats = Integer.parseInt(numSeatsField.getText());
            int price = Integer.parseInt(priceField.getText());
            db.insertFlight(destination, flightDate, numSeats, price);
        });
    }

    private void addDeleteButtonEvent() {
        deleteButton.setOnAction(event -> {
            int id = Integer.parseInt(idField.getText());
            db.deleteFlight(id);
        });
    }
}
