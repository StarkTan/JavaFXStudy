package com.stark.study.lesson_007;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        // 打开网页小技巧
        HostServices services = getHostServices();
        services.showDocument("www.baidu.com");


        Group group = new Group(); //Layout 类
        Button button = new Button("Hello World");
        button.setCursor(Cursor.OPEN_HAND); //修改 Button 的鼠标样式
        button.setPrefWidth(400);
        button.setPrefHeight(400);
        group.getChildren().add(button); //为布局类添加元素

        Scene scene = new Scene(group); // 必须添加node类

        scene.setCursor(Cursor.MOVE); //修改 Scene 的鼠标样式
        URL iconUrl = getClass().getClassLoader().getResource("icon//icon.gif"); // 这个需要经过maven编译后
//        URL iconUrl = getClass().getClassLoader().getResource("");
        scene.setCursor(Cursor.cursor(iconUrl.toString())); // 使用自定义图片作为图标
        primaryStage.setScene(scene);

        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX->Scene");
        primaryStage.show();
    }
}
