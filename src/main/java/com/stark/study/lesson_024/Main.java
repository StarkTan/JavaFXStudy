package com.stark.study.lesson_024;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Label nameLabel = new Label("账号 :");
        nameLabel.setFont(Font.font(14));
        Label pwdLabel = new Label("密码 :");
        pwdLabel.setFont(Font.font(14));

        TextField nameField = new TextField();
        nameField.setText("hello");
        nameField.setUserData("hello");
        nameField.setTooltip(new Tooltip("请输入账号"));
        PasswordField pwdField = new PasswordField();
        pwdField.setUserData("123456");
        pwdField.setText("123456");
        pwdField.setTooltip(new Tooltip("请输入密码"));

        Button loginBtn = new Button("登录");
        Button clearBtn = new Button("清除");


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color:#FFF0F5");
        gridPane.add(nameLabel,0,0);
        gridPane.add(nameField,1,0);
        gridPane.add(pwdLabel,0,1);
        gridPane.add(pwdField,1,1);
        gridPane.add(clearBtn,0,2);
        gridPane.add(loginBtn,1,2);

        gridPane.setHgap(5);
        gridPane.setVgap(15);

        GridPane.setMargin(loginBtn,new Insets(0,0,0,120));


        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setTitle("登录");
        primaryStage.setResizable(false);

        primaryStage.show();






        clearBtn.setOnAction(event -> {
            nameField.setText("");
            pwdField.setText("");
        });

        loginBtn.setOnAction(event -> {

//            nameField.setUserData("aaaaaa");
//            nameField.setUserData("bbbbbbb");
//            System.out.println(nameField.getUserData());

            String name = nameField.getText();
            String password = pwdField.getText();

            if(nameField.getUserData().equals(name)&&
            pwdField.getUserData().equals(password)){
                System.out.println("登录成功");
                new MyWindow(name,password);
                primaryStage.close();
            }else {
                System.out.println("登录失败");
                primaryStage.setTitle("账号或者密码输入错误");
                FadeTransition fadeTransition = new FadeTransition();
                fadeTransition.setDuration(Duration.seconds(0.1));
                fadeTransition.setNode(gridPane);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);

                fadeTransition.play();
            }

        });

    }
}

class MyWindow{

    private final Stage stage = new Stage();

    public MyWindow(String name,String password){

        Text text = new Text("用户名："+name+"  密码："+password);

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color:#FFC0CB");
        borderPane.setCenter(text);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }
}
