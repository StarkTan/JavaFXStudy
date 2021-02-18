package com.stark.study.lesson_005;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 *  platform runLater 使用
 *      使用UI线程 不建议添加长时间任务，会导致UI卡死
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        // 添加一个后置任务
        Platform.runLater(()->{
            System.out.println("runLater() 线程 ："+Thread.currentThread().getName());
            for(int i=10;i>1;i--){
                primaryStage.setTitle("Close Countdown : "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            primaryStage.close();
        });
        System.out.println("start() 线程 ："+Thread.currentThread().getName());
        primaryStage.show();
    }
}
