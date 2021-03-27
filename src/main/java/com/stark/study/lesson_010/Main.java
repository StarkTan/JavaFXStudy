package com.stark.study.lesson_010;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button();
        b1.setText("B1");
        b1.setPrefWidth(400);
        b1.setPrefHeight(200);
        b1.setFont(Font.font(40));

        //设计单击事件
        b1.setOnAction(event -> {
            System.out.println("B1的单击事件");
        });

        //使用事件监听器监听鼠标各种事件
        b1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {

            System.out.println("鼠标按键 + "+event.getButton().name());
            if(event.getClickCount()==2 && event.getButton().equals(MouseButton.PRIMARY)){
                System.out.println("当前鼠标按键 + "+event.getButton().name());
                System.out.println("鼠标双击事件");
            }
        });

        b1.setOnKeyPressed(event -> {
            //中文输入法会影响接受name
            System.out.println("按下 " + event.getCode().getName());
        });

        b1.setOnKeyReleased(event ->  {
            System.out.println("释放 " + event.getCode().getName());
            if(event.getCode().equals(KeyCode.A)){
                System.out.println("当前释放 A");
            }
        });

        Group root = new Group();

        root.getChildren().addAll(b1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);


        primaryStage.show();
    }
}
