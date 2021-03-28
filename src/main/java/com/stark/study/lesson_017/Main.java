package com.stark.study.lesson_017;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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

        FlowPane flowPane = new FlowPane();

        flowPane.setStyle("-fx-background-color:#EE6AA7");

        flowPane.getChildren().addAll(button1,button2,button3,button4);
        flowPane.getChildren().addAll(button5,button6,button7,button8);


        flowPane.setPadding(new Insets(10));
        FlowPane.setMargin(button1,new Insets(10));
        flowPane.setAlignment(Pos.CENTER); //会影响margin

        flowPane.setHgap(10); //设置水平间距
        flowPane.setVgap(10); //设置垂直间距
        flowPane.setOrientation(Orientation.VERTICAL); //设置放置方向

        Scene scene = new Scene(flowPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
