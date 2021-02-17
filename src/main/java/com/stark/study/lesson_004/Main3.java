package com.stark.study.lesson_004;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * stage 窗口模态
 */
public class Main3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Stage s1 = new Stage();
        s1.setTitle("S1");
        s1.show();

        Stage s2 = new Stage();
        //声明所有者
        s2.initOwner(s1);
        //阻止操作事件传递到所有者 (需要所有者先展示)
        s2.initModality(Modality.WINDOW_MODAL);

        s2.setTitle("S2");
        s2.show();

        Stage s3 = new Stage();
        //阻止所以事件传输到程序的其他窗口
        s3.initModality(Modality.APPLICATION_MODAL);


        s3.setTitle("S3");
        s3.show();


    }
}
