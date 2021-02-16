package com.stark.study.lesson_002;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX的第二种启动方式
 */
public class Main2 extends Application {

    public static void main(String[] args) {
        Application.launch(Main2.class,args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("这是Start方法");
    }
}
