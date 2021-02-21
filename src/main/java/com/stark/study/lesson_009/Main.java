package com.stark.study.lesson_009;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button();
        b1.setText("这是按钮");
        b1.setTextFill(Paint.valueOf("#CD0000")); //设置字体颜色
        b1.setLayoutY(100);
        b1.setLayoutX(100);

        b1.setPrefWidth(400);
        b1.setPrefHeight(200);

        b1.setFont(Font.font("sans-serif",40)); //设置字体样式

        // 设置按钮样式 背景
        BackgroundFill backgroundFill = new BackgroundFill(
                Paint.valueOf("#8FBC8F"),  //设置颜色
                new CornerRadii(20), // 设置圆角
//                new Insets(10)
                Insets.EMPTY //设置背景与边框距离
        );
        Background background = new Background(backgroundFill);
        b1.setBackground(background);

        // 设置按钮样式 边框
        BorderStroke stroke = new BorderStroke(
                Paint.valueOf("#8A2BEA"),  //设置颜色
                BorderStrokeStyle.DOTTED, //边框类型
                new CornerRadii(20), // 设置圆角
                new BorderWidths(10,10,5,5));//设置边框
        Border border = new Border(stroke);
        b1.setBorder(border);

        Button b2 = new Button();
        b2.setText("这是按钮二");
//        b2.setTextFill(Paint.valueOf("#CD0000")); //设置字体颜色
        b2.setLayoutY(500);
        b2.setLayoutX(100);

        b2.setPrefWidth(400);
        b2.setPrefHeight(200);
//// 设置按钮样式 背景
//        BackgroundFill backgroundFill2 = new BackgroundFill(
//                Paint.valueOf("#8FBC8F10"),  //设置颜色，后面两位表示透明度
//                new CornerRadii(20), // 设置圆角
////                new Insets(10)
//                Insets.EMPTY //设置背景与边框距离
//        );
//        Background background2 = new Background(backgroundFill2);
//        b2.setBackground(background2);


        // 使用CSS进行样式设置
        b2.setStyle(""+
                "-fx-background-color: #8FBC8F;" +
                        "-fx-background-radius:20;" +
                "-fx-background-insets:0;"+
                        "-fx-text-fill:#CD0000;"
        );


        //绑定点击事件
        b1.setOnAction(event -> {
            System.out.println(event.getSource());
        });



        Group root = new Group();

        root.getChildren().addAll(b1,b2);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);


        primaryStage.show();
    }
}
