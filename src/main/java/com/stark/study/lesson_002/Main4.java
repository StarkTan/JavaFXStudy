package com.stark.study.lesson_002;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX 生命周期
 */
public class Main4 extends Application {

    public static void main(String[] args) {
        System.out.println("调用main()方法 :" + Thread.currentThread().getName());
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("调用init()方法 :" + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //JavaFX Application Thread 是 UI线程
        System.out.println("调用start()方法 :" + Thread.currentThread().getName());
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("调用stop()方法 :" + Thread.currentThread().getName());
    }
}
