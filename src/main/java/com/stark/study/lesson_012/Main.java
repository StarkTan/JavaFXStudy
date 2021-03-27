package com.stark.study.lesson_012;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);


        Label label = new Label("我是标签: ");
        label.setTextFill(Paint.valueOf("red"));
        label.setLayoutY(100);
        PasswordField pText = new PasswordField();
        pText.setLayoutX(100);
        pText.setLayoutY(300);

        TextField text = new TextField();
        //text.setText("这是文本");

        text.setLayoutX(100);
        text.setLayoutY(100);
//        text.setPrefWidth(100);
//        text.setPrefHeight(100);
        text.setFont(Font.font(14));

        //设置提示信息
        Tooltip tip = new Tooltip("这是提示");
        tip.setFont(Font.font(14));
        text.setTooltip(tip);//鼠标放上后有延迟


        text.setPromptText("请输入7个字以下");
        text.setFocusTraversable(false); //取消焦点

        //监听变化进行进行输入限制
        text.textProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue.length()<=7){
                text.setText(newValue);
            }else {
                text.setText(oldValue);
            }
        });
        // 监听文字选择
        text.selectedTextProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));

        text.setOnMouseClicked((event -> {
            System.out.println("鼠标点击");
        }));

        root.getChildren().addAll(text,pText,label);

        primaryStage.show();
    }
}
