package com.stark.study.lesson_026;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("menu1");
        menu1.setOnAction(event -> {
            System.out.println("menu1.setOnAction");
        });
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4",new Button("xxx"));

        MenuItem menuItem1 = new MenuItem("item1",new ImageView("icon//icon.gif"));
        KeyCombination keyCombination = KeyCombination.valueOf("alt+k");
        menuItem1.setAccelerator(keyCombination);
        menuItem1.setOnAction(event -> {
            System.out.println("menuItem1.setOnAction");
        });
        menu1.setOnShown(event -> {
            System.out.println("menuItem1.setOnShown");
        });
        menu1.setOnHidden(event -> {
            System.out.println("menuItem1.setOnHidden");
        });
        menu1.setOnMenuValidation(event -> { //监听快捷键键响应
            System.out.println("menuItem1.setOnMenuValidation");
        });
        MenuItem menuItem2 = new MenuItem("item2");
        menuItem2.setOnAction(event -> {
            System.out.println("menuItem2.setOnAction");
        });
        MenuItem menuItem3 = new MenuItem("item3");
        MenuItem menuItem4 = new MenuItem("item4");
        MenuItem menuItem5 = new MenuItem("item5",new Button("123"));

        menu1.getItems().addAll(menuItem1,menuItem2,menuItem3);
        menu2.getItems().addAll(menuItem4,menuItem5);
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

        menuBar.setPrefWidth(anchorPane.getWidth());
        anchorPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            menuBar.setPrefWidth(newValue.doubleValue());
        });

    }
}
