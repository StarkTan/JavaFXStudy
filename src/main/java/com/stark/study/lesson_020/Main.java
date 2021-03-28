package com.stark.study.lesson_020;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Text text1 = new Text("这里是语句1"+System.getProperty("line.separator"));
        Text text2 = new Text("这里是语句2");
        Text text3 = new Text("这里是语句3");
        Text text4 = new Text("这里是语句4");

        TextFlow textFlow = new TextFlow();

        textFlow.setStyle("-fx-background-color:#EE6AA7");

        textFlow.getChildren().addAll(text1,text2,text3,text4);
        textFlow.setTextAlignment(TextAlignment.CENTER);
        textFlow.setLineSpacing(10);


        Scene scene = new Scene(textFlow);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
