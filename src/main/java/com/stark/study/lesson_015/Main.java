package com.stark.study.lesson_015;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    public void start(Stage primaryStage){

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        Button b5 = new Button("b3.setManaged(false-true)");
        Button b6 = new Button("b3.setVisible(false-true)");
        Button b7 = new Button("b3.setOpacity(0-1)");

//        b3.setManaged(false);
//        b3.setVisible(false);
//        b3.setOpacity(0);
        HBox hbox = new HBox();

        hbox.getChildren().addAll(b1,b2,b3,b4);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(b5,b6,b7);


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#9BCD98");
        anchorPane.getChildren().addAll(hbox,vbox);

        AnchorPane.setTopAnchor(vbox,100.0);
        AnchorPane.setLeftAnchor(vbox,20.0);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();


        b5.setOnAction(event -> {
            b3.setManaged(!b3.isManaged());
            System.out.println("当前hbox中组件数量 ： "+hbox.getChildren().size());
        });
        b6.setOnAction(event -> {
            b3.setVisible(!b3.isVisible());
            System.out.println("当前hbox中组件数量 ： "+hbox.getChildren().size());
        });
        b7.setOnAction(event -> {
            b3.setOpacity(b3.getOpacity()==0?1:0);
            System.out.println("当前hbox中组件数量 ： "+hbox.getChildren().size());
        });
    }
}
