package com.stark.study.lesson_052;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Student student = new Student("A",12);


        primaryStage.setTitle("JavaFX 数据绑定");
        primaryStage.show();

        student.ageProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("age old : "+oldValue);
            System.out.println("age new : "+newValue);
        }));

        student.nameProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println("name old : "+oldValue);
            System.out.println("name new : "+newValue);
        }));

        student.setName("B");
        student.setAge(28);

        System.out.println("current name :"+student.getName());
        System.out.println("current age :"+student.getAge());
    }
}
