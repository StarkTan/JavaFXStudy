package com.stark.study.lesson_111;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);

        ProgressBar progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(200);

        Button start = new Button("开始");

        Button cancel = new Button("取消");
        Button restart = new Button("重启");
        Button reset = new Button("重置");

        Label state = new Label("state");
        Label value = new Label("value");
        Label title = new Label("title");
        Label message = new Label("message");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#EEEEEE");

        hBox.getChildren().addAll(start,cancel,restart,reset,progressBar,state,value,title,message);

        anchorPane.getChildren().addAll(hBox);

        AnchorPane.setTopAnchor(hBox,100.0);
        AnchorPane.setLeftAnchor(hBox, 20.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.show();

        MyScheduledService service = new MyScheduledService();
        service.setDelay(Duration.seconds(5));
        service.setPeriod(Duration.seconds(1));
        service.setRestartOnFailure(true);
        service.setMaximumFailureCount(3);

        start.setOnAction(event -> {
            service.start();
        });
        cancel.setOnAction(event -> {
            service.cancel();
        });
        restart.setOnAction(event -> {
            service.restart();
        });
        reset.setOnAction(event -> {
            service.reset();
        });


        service.valueProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                value.setText(newValue.intValue()+"");
            }
        });

        service.lastValueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("lastValueProperty:"+newValue);
        });
    }
}

class MyScheduledService extends ScheduledService<Number> {

    private int count = 0;

    @Override
    protected Task<Number> createTask() {

        System.out.println("createTask()");
        return new Task<Number>() {
            @Override
            protected void updateValue(Number value) {
                super.updateValue(value);
                if(count==10){
                    MyScheduledService.this.cancel();
                    System.out.println("cancel MyScheduledService");
                }
            }

            @Override
            protected Number call() throws Exception {
                count++;
                System.out.println("count : "+count);
            return count;
            }
        };
    }
}