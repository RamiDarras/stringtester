package com.stringtest;

import javafx.application.Application;
import javafx.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.*;

public class Javafx extends Application {

    @Override
    public void start(Stage stage) {
        List<Integer> carIds = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        List<String> carNames = Arrays.asList(
                "Toyota Camry", "Honda Accord", "Ford Mustang", "Chevrolet Malibu", "Nissan Altima",
                "BMW 3 Series", "Audi A4", "Mercedes-Benz C-Class", "Tesla Model 3", "Hyundai Sonata",
                "Kia Optima", "Volkswagen Passat", "Subaru Legacy", "Mazda 6", "Volvo S60",
                "Jaguar XE", "Lexus IS", "Infiniti Q50", "Acura TLX", "Alfa Romeo Giulia");
        List<String> carMotorModels = Arrays.asList(
                "2AR-FE", "K24W1", "Coyote V8", "LFV", "QR25DE",
                "B58", "EA888", "M274", "Electric", "G4KJ",
                "EA888", "FB25", "SH-VPTS", "B4204T23",
                "Ingenium", "8AR-FTS", "VR30DDTT", "K24W7", "2.0 GME T4");
        List<Double> carPrices = Arrays.asList(
                24425.0, 24800.0, 55000.0, 22395.0, 24450.0,
                41250.0, 39900.0, 41900.0, 39990.0, 23700.0,
                23590.0, 23995.0, 22945.0, 24475.0, 38950.0,
                39900.0, 39250.0, 36900.0, 37900.0, 40945.0);
        List<Integer> ssns = Arrays.asList(
                123456789, 987654321, 111223333, 444556666, 777889999,
                222334444, 555667777, 888990000, 333445555, 666778888,
                999001111, 11222222, 111224444, 222335555, 333446666,
                444557777, 555668888, 666779999, 777880000, 888991111);
        List<String> firstNames = Arrays.asList(
                "John", "Jane", "Michael", "Sarah", "David",
                "Emily", "Chris", "Jessica", "Matthew", "Ashley",
                "Daniel", "Amanda", "James", "Megan", "Joshua",
                "Rachel", "Andrew", "Laura", "Joseph", "Sophia");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cars", "root", "");

            Statement selectStmt = con.createStatement();
            Statement insertStmt = con.createStatement();
            Statement delStatement = con.createStatement();

            

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        TextField textBoxCarName = new TextField();
        textBoxCarName.setPromptText("Enter car name");
        
        TextField textBoxCarIds = new TextField();
        textBoxCarIds.setPromptText("Enter car ID");
        
        TextField textBoxCarMotorModels = new TextField();
        textBoxCarMotorModels.setPromptText("Enter car motor model");
        
        TextField textBoxCarPrices = new TextField();
        textBoxCarPrices.setPromptText("Enter car price");
        
        TextField textBoxSsn = new TextField();
        textBoxSsn.setPromptText("Enter SSN");
        
        TextField textBoxFirstName = new TextField();
        textBoxFirstName.setPromptText("Enter first name");
        
        VBox root = new VBox();
        root.getChildren().addAll(
            new Label("Enter car ID: "), textBoxCarIds,
            new Label("Enter car name: "), textBoxCarName, 
            new Label("Enter car motor model: "), textBoxCarMotorModels,
           new Label("Enter car price: "),textBoxCarPrices, 
        new Label("Enter SSN: "),textBoxSsn, 
        new Label("Enter First Name: "), textBoxFirstName
        );
        Button button = new Button("Submit");
        button.setOnAction(e -> {
           
        });
        
        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}