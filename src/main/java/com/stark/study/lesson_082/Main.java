package com.stark.study.lesson_082;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button button = new Button("button");

        ObservableList<String> observableList = FXCollections.observableArrayList();
        observableList.add("data - a");
        observableList.add("data - b");
        observableList.add("data - c");
        observableList.add("data - d");
        observableList.add("data - e");
        observableList.add("data - f");
        observableList.add("data - g");
        observableList.add("data - h");
        observableList.add("data - i");

        ListView<String> listView = new ListView<>(observableList);
        listView.setPrefWidth(300);
        listView.setPrefHeight(100);
        listView.getItems().add("xxxx000000000000");
//        listView.setOrientation(Orientation.HORIZONTAL);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listView.setPlaceholder(new Label("没有数据"));

        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().addAll(button,listView);
        AnchorPane.setLeftAnchor(listView,100.0);
        AnchorPane.setTopAnchor(listView,100.0);

        Scene scene = new Scene(anchorPane);

        primaryStage.setTitle("ListView");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(event -> {
//            observableList.add("button add");
//            observableList.set(0,"button update");
//            observableList.remove(1);
//            System.out.println(listView.getSelectionModel().getSelectedItems());
            listView.getSelectionModel().selectLast();
            listView.scrollTo(observableList.size());
            listView.requestFocus();
        });

        listView.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("old index : "+oldValue);
            System.out.println("new index : "+newValue);
        });
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("old index : "+oldValue);
            System.out.println("new index : "+newValue);
        });
    }
}
