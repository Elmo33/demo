package com.example.demo;

import java.sql.*;
import java.util.Date;

public class MySQLDatabase {

    private Connection con;
    private final String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11592276";
    private final String user = "sql11592276";
    private final String password = "T1RVdyTmP2";

    public MySQLDatabase() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFlight(String destination, Date flightDate, int numSeats, int price) {
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO flights (destination, flight_date, num_seats, price) VALUES (?,?,?,?)");
            st.setString(1, destination);
            st.setDate(2, (java.sql.Date) flightDate);
            st.setInt(3, numSeats);
            st.setInt(4, price);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getFlights() throws SQLException {
        Statement st = con.createStatement();
        return st.executeQuery("SELECT destination, num_seats FROM flights");
    }
    public void updateFlight(int id, String destination, int numSeats, int price) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE flights SET destination = ?, num_seats = ?, price = ? WHERE id = ?");
            pst.setString(1, destination);
            pst.setInt(2, numSeats);
            pst.setInt(3, price);
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteFlight(int id) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM flights WHERE flight_id = ?");
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Test");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}