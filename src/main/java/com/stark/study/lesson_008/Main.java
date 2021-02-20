package com.stark.study.lesson_008;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("JavaFX");

        Button b1 = new Button("b1");
        b1.setLayoutX(0);
        b1.setLayoutY(0);
        b1.setPrefWidth(50);
        Button b2 = new Button("b2");
        b2.setLayoutX(100);
        b2.setLayoutY(100);
        b2.setPrefWidth(50);
        Button b3 = new Button("b3");
        b3.setLayoutX(200);
        b3.setLayoutY(200);
        b3.setPrefHeight(50);
        //添加组件
//        group.getChildren().add(b1);
//        group.getChildren().add(b2);
//        group.getChildren().add(b3);

        //批量添加元素
        group.getChildren().addAll(b1,b2,b3);

        //移除元素
//        group.getChildren().remove(1);
//        group.getChildren().remove(b1);
//        group.getChildren().clear();

//        group.setAutoSizeChildren(false); // 是否自动设置高宽

//        group.setOpacity(0.5); //统一透明度设置

//        System.out.println(group.contains(0,0)); //检查点是否在子组件左上角
//        System.out.println(group.contains(0,1)); //检查点是否在子组件左上角

        group.getChildren().addListener((ListChangeListener<Node>) c ->{
         System.out.println("监听到组件数量变化,当前个数 "+ c.getList().size());
        });

        b1.setOnAction(event -> {
            Button b4 = new Button("b4");
            b4.setLayoutX(300);
            b4.setLayoutY(300);
            group.getChildren().add(b4);
        });

        primaryStage.show();

    }
}
