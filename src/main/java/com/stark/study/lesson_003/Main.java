package com.stark.study.lesson_003;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Stage 窗口API使用
 */
public class Main  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //自建窗口也可以显示
        //Stage stage = new Stage();
        //stage.show();

        //设置标题
        primaryStage.setTitle("JavaFX");
        //设置图标
        primaryStage.getIcons().add(new Image("https://static.easyicon.net/preview/56/564570.gif"));

        // primaryStage.setIconified(true); //设置最小化
        // primaryStage.setMaximized(true); //设置最大化

//        primaryStage.setWidth(500); //设置高度
//        primaryStage.setHeight(500); // 设置宽度
        //primaryStage.setResizable(false);//不允许改变窗口大小

        //primaryStage.setMaxHeight(1000); //设置最大高度
        //primaryStage.setMaxWidth(1000); //设置最大宽度

        primaryStage.setMinHeight(500); //设置最小高度
        primaryStage.setMinWidth(500); // 设置最小宽度

        System.out.println("当前宽度: "+primaryStage.getWidth());
        System.out.println("当前高度度: "+primaryStage.getHeight());

        // 高度变化监听
        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("窗口高度改变 : "+oldValue + " ->" +newValue);
        });

        // 宽度变化监听
        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("窗口宽度改变 : "+oldValue + " ->" +newValue);
        });

        //设置全屏
        primaryStage.setFullScreen(true);
        primaryStage.setScene(new Scene(new Group()));

        primaryStage.show(); //窗口显示
        // 在没有设置宽高的情况下，默认值在show之后生成
        System.out.println("当前宽度: "+primaryStage.getWidth());
        System.out.println("当前高度度: "+primaryStage.getHeight());

        //primaryStage.close(); //窗口关闭

    }
}
