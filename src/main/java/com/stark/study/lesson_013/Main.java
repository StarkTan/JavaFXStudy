package com.stark.study.lesson_013;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button b1 = new Button("Button1");
        Button b2 = new Button("Button2");
        Button b3 = new Button("Button3");
        Button b4 = new Button("Button4");

        Group group1 = new Group();
        group1.getChildren().addAll(b1,b2);
        Group group2 = new Group();
        group2.getChildren().addAll(b3,b4);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#EEEEEE");
        anchorPane.setOnMouseClicked((event)-> System.out.println("Clicked"));

        anchorPane.getChildren().addAll(group1,group2);

        AnchorPane.setLeftAnchor(group2,100.0);
        AnchorPane.setTopAnchor(group2,100.0);

        b4.setLayoutX(100);
        b4.setLayoutY(100);

        // 设置距离后会改变组件大小
        //AnchorPane.setTopAnchor(b1,0.0); //设置距离父控件顶部 10px
//        AnchorPane.setLeftAnchor(b1,10.0); //设置距离父控件左边 10px
//        AnchorPane.setBottomAnchor(b1,10.0);
//        AnchorPane.setRightAnchor(b1,10.0);

        //b1.setPadding(new Insets(10,0,0,0));

        // b1.setLayoutX(100); 定位布局优先直接设置坐标点

        // Group只是容器
//        Group root = new Group();
//        root.setStyle("-fx-background-color:red");
//        root.setOnMouseClicked((event)-> System.out.println("Clicked"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);




        primaryStage.show();
    }
}
