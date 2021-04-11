package com.stark.study.lesson_025;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Hyperlink hyperlink = new Hyperlink("www.baidu.com",new Button("百度一下"));

        hyperlink.setOnAction(event -> {
            HostServices hostServices = Main.this.getHostServices();
            hostServices.showDocument(hyperlink.getText());// 使用默认浏览器打开地址
        });

        VBox vbox = new VBox();

        vbox.getChildren().add(hyperlink);

        Scene scene = new Scene(vbox);


        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}
