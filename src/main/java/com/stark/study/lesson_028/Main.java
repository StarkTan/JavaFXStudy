package com.stark.study.lesson_028;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
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


        //CustomMenuItem
        CustomMenuItem customMenuItem1 = new CustomMenuItem();
        Button button = new Button("button1");
        customMenuItem1.setContent(button);

        CustomMenuItem customMenuItem2 = new CustomMenuItem();
        ProgressBar progressBar = new ProgressBar(0.5);
        customMenuItem2.setContent(progressBar);

        CustomMenuItem customMenuItem3 = new CustomMenuItem();
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color:#FF3E96");
        hbox.setSpacing(10);
        hbox.getChildren().addAll(new Button("b1"),new Button("b2"));
        customMenuItem3.setContent(hbox);

        //MenuButton
        MenuButton menuButton = new MenuButton("menuButton");
        MenuItem menuItem4 = new MenuItem("item4");
        MenuItem menuItem5 = new MenuItem("item5");
        MenuItem menuItem6 = new MenuItem("item6");
        menuButton.getItems().addAll(menuItem4,menuItem5,menuItem6);

        //SplitMenuButton 只是和 MenuButton 长的不一样
        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText("SplitMenuButton");
        MenuItem menuItem7 = new MenuItem("item7");
        MenuItem menuItem8 = new MenuItem("item8");
        MenuItem menuItem9 = new MenuItem("item9");
        splitMenuButton.getItems().addAll(menuItem7,menuItem8,menuItem9);

        //ContextMenu 右键菜单
        Button button1 = new Button("button1");
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem10 = new MenuItem("item10");
        MenuItem menuItem11 = new MenuItem("item11");
        MenuItem menuItem12 = new MenuItem("item12");
        contextMenu.getItems().addAll(menuItem10,menuItem11,menuItem12);
        button1.setContextMenu(contextMenu);
        button1.setOnContextMenuRequested(event -> { //右键菜单弹出时触发
            System.out.println("button1.setOnContextMenuRequested");
        });

        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3,
                customMenuItem1,customMenuItem2,customMenuItem3);

        menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#ffffff");
        anchorPane.getChildren().add(menuBar);
        anchorPane.getChildren().add(menuButton);
        AnchorPane.setTopAnchor(menuButton,25.0);

        anchorPane.getChildren().add(splitMenuButton);
        AnchorPane.setTopAnchor(splitMenuButton,50.0);

        anchorPane.getChildren().add(button1);
        AnchorPane.setTopAnchor(button1,80.0);


        Scene scene = new Scene(anchorPane);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(500);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();



        menuBar.setPrefWidth(anchorPane.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            menuBar.setPrefWidth(newValue.doubleValue());
        });

    }
}
