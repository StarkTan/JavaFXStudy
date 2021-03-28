package com.stark.study.lesson_019;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color:#EE6AA7");
        stackPane.getChildren().addAll(button1,button2,button3,button4,button5);

        stackPane.setPadding(new Insets(10));
        stackPane.setAlignment(Pos.BOTTOM_LEFT);
        StackPane.setMargin(button1,new Insets(100));

        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
