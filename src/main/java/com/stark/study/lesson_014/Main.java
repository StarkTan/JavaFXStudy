package com.stark.study.lesson_014;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("Button1");

        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#9BCD98");

        //HBox box = new HBox();
        VBox box = new VBox();
        box.setStyle("-fx-background-color:#EEEEEE");
        box.setPrefHeight(400);
        box.setPrefWidth(400);
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        VBox.setMargin(b1,new Insets(10));
        box.setAlignment(Pos.BOTTOM_CENTER);

        box.getChildren().addAll(b1,b2,b3);
        anchorPane.getChildren().add(box);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);

        primaryStage.show();
    }
}
