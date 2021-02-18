package com.stark.study.lesson_006;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Screen screen = Screen.getPrimary();//获取主屏幕

        Rectangle2D bounds = screen.getBounds(); // 屏幕高宽度数据
        Rectangle2D bounds1 = screen.getVisualBounds();//屏幕可视高宽度数据
        double dpi = screen.getDpi(); // 屏幕每英寸像素(像素密度)

        System.out.println("屏幕DPI数据: "+dpi);

        System.out.println("屏幕高宽 H,W =" + bounds.getHeight()+","+bounds.getWidth());
        System.out.println("屏幕左上角 X,Y =" + bounds.getMinX()+","+bounds.getMinY());
        System.out.println("屏幕右下角 X,Y =" + bounds.getMaxX()+","+bounds.getMaxY());

        System.out.println("可视屏幕高宽 H,W =" + bounds1.getHeight()+","+bounds1.getWidth());
        System.out.println("可视屏幕左上角 X,Y =" + bounds1.getMinX()+","+bounds1.getMinY());
        System.out.println("可视屏幕右下角 X,Y =" + bounds1.getMaxX()+","+bounds1.getMaxY());

        primaryStage.show();
    }
}
