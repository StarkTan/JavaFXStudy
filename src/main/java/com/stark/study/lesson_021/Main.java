package com.stark.study.lesson_021;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * 每个元素占的空间大小相同，以最大的为准
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Button b1 = new Button("button1");
        b1.setStyle("-fx-background-color:#EE0000");
        b1.setPrefHeight(40);
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");
        Button b5 = new Button("button5");
        Button b6 = new Button("button6");
        Button b7 = new Button("button7");
        Button b8 = new Button("button8");

        TilePane tilePane = new TilePane();
        tilePane.setStyle("-fx-background-color:#EE6AA7");
        tilePane.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8);

        tilePane.setHgap(10);
        tilePane.setVgap(10);
        tilePane.setPadding(new Insets(10));
        tilePane.setAlignment(Pos.BOTTOM_LEFT);
        TilePane.setMargin(b1,new Insets(50)); //每个元素的效果都是一样的


        Scene scene = new Scene(tilePane);

        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
