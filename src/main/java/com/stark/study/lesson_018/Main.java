package com.stark.study.lesson_018;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        Button button6 = new Button("Button6");
        Button button7 = new Button("Button7");
        Button button8 = new Button("Button8");

        GridPane gridPane = new GridPane();

        gridPane.setStyle("-fx-background-color:#EE6AA7");


        gridPane.add(button1,0,0);
        //gridPane.add(button2,1,0);
        gridPane.add(button3,2,0);
        gridPane.add(button4,3,0);
        gridPane.add(button5,0,1);
        gridPane.add(button6,1,1);
        gridPane.add(button7,2,1);
        gridPane.add(button8,3,1);


        gridPane.getChildren().addAll(button2);
        //GridPane.setConstraints(button2,1,0);
        GridPane.setColumnIndex(button2,1);
        GridPane.setRowIndex(button2,0);
        gridPane.setPadding(new Insets(10));
        GridPane.setMargin(button1,new Insets(10));
        gridPane.setAlignment(Pos.CENTER); //会影响margin

        gridPane.setHgap(10); //设置水平间距
        gridPane.setVgap(10); //设置垂直间距

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
