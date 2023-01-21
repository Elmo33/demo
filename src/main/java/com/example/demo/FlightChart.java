package com.example.demo;

import com.example.demo.MySQLDatabase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightChart extends Application {

    private final MySQLDatabase db;
    private final BarChart<String, Number> barChart;

    public FlightChart(){
        db = new MySQLDatabase();
        barChart = new BarChart<>(new CategoryAxis(), new NumberAxis());
        barChart.setTitle("Flights by Destination");
    }

    @Override
    public void start(Stage stage) {
        BarChart<String, Number> chart = getChart();
        Scene scene = new Scene(chart,800,600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public BarChart<String, Number> getChart(){
        try {
            ResultSet result = db.getFlights();
            while (result.next()){
                String destination = result.getString("destination");
                int numSeats = result.getInt("num_seats");
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.setName(destination);
                series.getData().add(new XYChart.Data<>(destination, numSeats));
                barChart.getData().add(series);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barChart;
    }

}