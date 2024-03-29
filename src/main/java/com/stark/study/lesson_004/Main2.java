package com.stark.study.lesson_004;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Stage 的5种类型
 */
public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Stage s1 = new Stage();
        s1.setTitle("s1");
        s1.initStyle(StageStyle.DECORATED); // 纯白背景和平台装饰 默认
        s1.show();

        Stage s2 = new Stage();
        s2.setTitle("s2");
        s2.initStyle(StageStyle.TRANSPARENT); // 透明背景且没有装饰
        s2.show();

        Stage s3 = new Stage();
        s3.setTitle("s3");
        s3.initStyle(StageStyle.UNDECORATED); // 纯白背景，无装饰
        s3.show();

        Stage s4 = new Stage();
        s4.setTitle("s4");
        s4.initStyle(StageStyle.UNIFIED);// 纯白背景和最少平台装饰
        s4.show();

        Stage s5 = new Stage();
        s5.setTitle("s5");
        s5.initStyle(StageStyle.UTILITY); // 客户区背景与装饰统一,有平台装饰
        s5.show();

        //Platform.exit(); // 平台工具，关闭任务
    }
}
