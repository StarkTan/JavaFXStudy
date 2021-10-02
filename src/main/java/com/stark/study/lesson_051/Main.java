package com.stark.study.lesson_051;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Student s = new Student("Stark", 18);

        primaryStage.setTitle("JavaFX 数据绑定");
        primaryStage.show();

        s.getPropertyChangeSupport().addPropertyChangeListener(evt -> {
            System.out.println("oleValue: "+ evt.getOldValue());
            System.out.println("newValue: "+ evt.getNewValue());
        });

        s.getPropertyChangeSupport().addPropertyChangeListener("StudentNameChange", evt -> {
            System.out.println(s.equals(evt.getSource()));
            System.out.println("name oleValue: "+ evt.getOldValue());
            System.out.println("name newValue: "+ evt.getNewValue());
        });

        s.setName("Stark 1");
        s.setAge(28);
    }
}
