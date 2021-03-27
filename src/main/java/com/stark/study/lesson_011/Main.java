package com.stark.study.lesson_011;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {


        Button b1 = new Button();
        b1.setText("B1");
        b1.setPrefWidth(400);
        b1.setPrefHeight(200);
        b1.setFont(Font.font(40));

        b1.setOnAction(event -> {
            play();
        });



        Group root = new Group();

        root.getChildren().addAll(b1);

        Scene scene = new Scene(root);

        //绑定快捷键需要在Scene中进行
        KeyCombination kc1 = new KeyCodeCombination(KeyCode.C,KeyCombination.ALT_DOWN,KeyCombination.CONTROL_DOWN);
        Mnemonic mnemonic1 = new Mnemonic(b1,kc1);
        scene.addMnemonic(mnemonic1);

        KeyCombination kc2 = new KeyCharacterCombination("O",KeyCombination.ALT_DOWN);
        Mnemonic mnemonic2 = new Mnemonic(b1,kc2);
        scene.addMnemonic(mnemonic2);

        // SHORTCUT_DOWN 对应Win的 CTRL
        KeyCombination kccb = new KeyCodeCombination(KeyCode.A,KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kccb,()->{

            System.out.println("执行组合键效果");
            //System.out.println("组合键执行线程 ： "+Thread.currentThread().getName()); //JavaFX Application Thread
            play();
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);


        primaryStage.show();
    }


    private static void play(){
        System.out.println("OnAction");
    }
}
