package com.stark.study.lesson_013;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#EEEEEE");
        anchorPane.setOnMouseClicked((event)-> System.out.println("Clicked"));

        AnchorPane anchorPane2 = new AnchorPane();
        anchorPane2.setStyle("-fx-background-color:#9BCD98");
        anchorPane2.setOnMouseClicked((event)-> System.out.println("Clicked"));

        AnchorPane anchorPane3 = new AnchorPane();
        anchorPane3.setStyle("-fx-background-color:red");
        anchorPane3.setOnMouseClicked((event)-> System.out.println("Clicked"));

        anchorPane.getChildren().add(anchorPane2);
        AnchorPane.setTopAnchor(anchorPane2,100.0);
        AnchorPane.setBottomAnchor(anchorPane2,100.0);
        AnchorPane.setLeftAnchor(anchorPane2,100.0);
        AnchorPane.setRightAnchor(anchorPane2,100.0);

        AnchorPane.setTopAnchor(anchorPane3,100.0);
        AnchorPane.setBottomAnchor(anchorPane3,100.0);
        AnchorPane.setLeftAnchor(anchorPane3,100.0);
        AnchorPane.setRightAnchor(anchorPane3,100.0);

        anchorPane2.getChildren().add(b1);
        b1.setOnMouseClicked(event -> {
            anchorPane.getChildren().remove(anchorPane2);
            anchorPane.getChildren().add(anchorPane3);
        });

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);

        primaryStage.show();
    }
}
