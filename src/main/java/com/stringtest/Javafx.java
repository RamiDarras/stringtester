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

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Javafx extends Application {

        private ObservableList<ObservableList> data;
        private TableView tableview;

        // CONNECTION DATABASE
        @SuppressWarnings({ "rawtypes", "unchecked" })
        public void buildData() {
                Connection c;
                data = FXCollections.observableArrayList();
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection(
                                        "jdbc:mysql://localhost:3306/fx", "root", ""); // SQL FOR SELECTING ALL OF
                                                                                       // CUSTOMER
                        String SQL = "SELECT * from car";
                        // ResultSet
                        ResultSet rs = con.createStatement().executeQuery(SQL);

                        /**********************************
                         * TABLE COLUMN ADDED DYNAMICALLY *
                         **********************************/
                        for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                                // We are using non property style for making dynamic table
                                final int j = i;
                                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                                col.setCellValueFactory(
                                                new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                                                        public ObservableValue<String> call(
                                                                        CellDataFeatures<ObservableList, String> param) {
                                                                return new SimpleStringProperty(
                                                                                param.getValue().get(j).toString());
                                                        }
                                                });

                                tableview.getColumns().addAll(col);
                                System.out.println("Column [" + i + "] ");
                        }

                        /********************************
                         * Data added to ObservableList *
                         ********************************/
                        while (rs.next()) {
                                // Iterate Row
                                ObservableList<String> row = FXCollections.observableArrayList();
                                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                                        // Iterate Column
                                        row.add(rs.getString(i));
                                }
                                System.out.println("Row [1] added " + row);
                                data.add(row);

                        }

                        // FINALLY ADDED TO TableView
                        tableview.setItems(data);
                } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error on Building Data");
                }
        }

        @Override
        public void start(Stage stage) throws Exception {
                // TableView
                tableview = new TableView();
                buildData();
                stage.setWidth(285);
                // stage.setMaxWidth(285);
                // stage.setMinWidth(285);
                stage.setTitle("Java Fx 2.0 DataBase Connection");
                stage.setResizable(false);
                // Main Scene
                Scene scene = new Scene(tableview);

                stage.setScene(scene);
                stage.show();
        }

        public static void main(String[] args) {
                launch(args);
        }

}