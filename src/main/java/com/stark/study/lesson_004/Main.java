package com.stark.study.lesson_004;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

//        primaryStage.opacityProperty().set(0.5); //设置窗口透明度 0-1
//        primaryStage.setAlwaysOnTop(true); //设置窗口置顶


        // 设置初始左上角坐标
        primaryStage.setX(100);
        primaryStage.setY(100);
        // 监听窗口位置变化
        primaryStage.xProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("窗口位置变化 X : "+oldValue +" -> "+newValue);
        }));
        primaryStage.yProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("窗口位置变化 Y : "+oldValue +" -> "+newValue);
        }));
        primaryStage.show();
    }
}
