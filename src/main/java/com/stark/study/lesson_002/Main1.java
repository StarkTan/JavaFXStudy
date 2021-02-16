package com.stark.study.lesson_002;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX 启动的第一种方式
 */
public class Main1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("这是Start方法");
    }
}
