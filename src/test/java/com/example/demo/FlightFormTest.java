package com.example.demo;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class FlightFormTest {

    @Test
    public void testInsertFlight() {
        MySQLDatabase db = new MySQLDatabase();
        String destination = "Paris";
        java.sql.Date flightDate = java.sql.Date.valueOf("2022-10-10");
        int numSeats = 150;
        int price = 200;
        db.insertFlight(destination, flightDate, numSeats, price);
        //assert that flight is inserted successfully
    }

    @Test
    public void testGetFlights() throws SQLException {
        MySQLDatabase db = new MySQLDatabase();
        // insert some flights
        ResultSet flights = db.getFlights();
        //assert that the returned flights match the inserted flights

    }
}