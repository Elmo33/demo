package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class MySQLDatabaseTest {

    private MySQLDatabase db;

    @BeforeEach
    public void setUp() {
        db = new MySQLDatabase();
    }

    @AfterEach
    public void tearDown() {
        db.close();
    }

    @Test
    public void testInsertFlight() {
        String destination = "Paris";
        java.sql.Date flightDate = java.sql.Date.valueOf("2022-10-10");
        int numSeats = 150;
        int price = 200;
        db.insertFlight(destination, flightDate, numSeats, price);
        //assert that flight is inserted successfully
    }

    @Test
    public void testGetFlights() throws SQLException {
        // insert some flights
        ResultSet flights = db.getFlights();
        //assert that the returned flights match the inserted flights
    }
}