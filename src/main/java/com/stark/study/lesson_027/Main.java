package com.stark.study.lesson_027;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("menu1");

        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");

        MenuItem menuItem1 = new MenuItem("item1");
        MenuItem menuItem2 = new MenuItem("item2");
        MenuItem menuItem3 = new MenuItem("item3");
        MenuItem menuItem4 = new MenuItem("item4");

        //分割线
        SeparatorMenuItem separator1 = new SeparatorMenuItem();
        SeparatorMenuItem separator2 = new SeparatorMenuItem();

        //子菜单
        Menu menu = new Menu("子菜单");
        MenuItem menuItem5 = new MenuItem("item5");
        MenuItem menuItem6 = new MenuItem("item6");
        menu.getItems().addAll(menuItem5,menuItem6);

        //菜单组,单选
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem radioMenuItem1 = new RadioMenuItem("radioMenuItem1");
        RadioMenuItem radioMenuItem2 = new RadioMenuItem("radioMenuItem2");
        RadioMenuItem radioMenuItem3 = new RadioMenuItem("radioMenuItem3");
        radioMenuItem1.setToggleGroup(toggleGroup);
        radioMenuItem2.setToggleGroup(toggleGroup);
        radioMenuItem3.setToggleGroup(toggleGroup);
        radioMenuItem1.setSelected(true);//默认选择

        // 勾选菜单项
        CheckMenuItem checkMenuItem1 = new CheckMenuItem("checkMenuItem1");
        CheckMenuItem checkMenuItem2 = new CheckMenuItem("checkMenuItem2");
        checkMenuItem2.setVisible(false);
        CheckMenuItem checkMenuItem3 = new CheckMenuItem("checkMenuItem3");
        checkMenuItem3.setDisable(true);

        menu1.getItems().addAll(menuItem1,separator1,menuItem2,separator2,menuItem3,menuItem4,menu);
        menu2.getItems().addAll(radioMenuItem1,radioMenuItem2,radioMenuItem3);
        menu3.getItems().addAll(checkMenuItem1,checkMenuItem2,checkMenuItem3);

        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#ffffff");
        anchorPane.getChildren().add(menuBar);


        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();


        radioMenuItem1.setOnAction(event -> {
            RadioMenuItem r = (RadioMenuItem) event.getSource();
            System.out.println("radioMenuItem1 当前选择状态: "+r.isSelected());
        });

        checkMenuItem1.setOnAction(event -> {
            CheckMenuItem c = (CheckMenuItem) event.getSource();
            System.out.println(" checkMenuItem1 当前选择状态: "+c.isSelected());
        });



        menuBar.setPrefWidth(anchorPane.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            menuBar.setPrefWidth(newValue.doubleValue());
        });

    }
}
