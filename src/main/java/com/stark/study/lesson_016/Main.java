package com.stark.study.lesson_016;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Button button = new Button("button");


        AnchorPane anchorPane1 = new AnchorPane();
//        anchorPane1.setPrefWidth(100);
        anchorPane1.setPrefHeight(100);
        anchorPane1.setStyle("-fx-background-color:#EE6AA7");

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setPrefWidth(100);
        anchorPane2.setPrefHeight(100);
        anchorPane2.setStyle("-fx-background-color:#98FB98");

        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setPrefWidth(100);
        anchorPane3.setPrefHeight(100);
        anchorPane3.setStyle("-fx-background-color:#A0522D");

        AnchorPane anchorPane4 = new AnchorPane();
        anchorPane4.setPrefWidth(100);
        anchorPane4.setPrefHeight(100);
        anchorPane4.setStyle("-fx-background-color:#1E90FF");

        AnchorPane anchorPane5 = new AnchorPane();
        anchorPane5.setStyle("-fx-background-color:#EEEE00");



        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color:#B23AEE");

//        borderPane.setTop(button);
        borderPane.setTop(anchorPane1);
        borderPane.setBottom(anchorPane2);
        borderPane.setLeft(anchorPane3);
        borderPane.setRight(anchorPane4);
        borderPane.setCenter(anchorPane5);

        borderPane.setPadding(new Insets(10));

        BorderPane.setMargin(anchorPane1,new Insets(10));

//        BorderPane.setAlignment(button, Pos.CENTER);

//        System.out.println(borderPane.getTop());
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
