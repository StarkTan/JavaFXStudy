package com.stark.study.lesson_005;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Platform.setImplicitExit(true); // 设置程序是否跟随最后一个窗口关闭
        boolean supported = Platform.isSupported(ConditionalFeature.MEDIA);//获取平台支持特性
        System.out.println(supported);
        primaryStage.show();
//        Platform.exit();
    }
}
