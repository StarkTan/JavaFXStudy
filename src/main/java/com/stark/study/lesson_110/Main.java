package com.stark.study.lesson_110;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
//        AnchorPane.setLeftAnchor(hBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.show();

        MyService service = new MyService();

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

        service.progressProperty().addListener((observable, oldValue, newValue) -> {
            progressBar.setProgress(newValue.doubleValue());
        });

        service.messageProperty().addListener((observable, oldValue, newValue) -> {
            message.setText(newValue);
        });
    }



}

class MyService extends Service<Number> {

    @Override
    protected void ready() {
        super.ready();
        System.out.println("ready :" + Platform.isFxApplicationThread());
    }

    @Override
    protected void scheduled() {
        super.scheduled();
        System.out.println("scheduled :" + Platform.isFxApplicationThread());
    }

    @Override
    protected void running() {
        super.running();
        System.out.println("running :" + Platform.isFxApplicationThread());
    }

    @Override
    protected void succeeded() {
        super.succeeded();
        System.out.println("succeeded :" + Platform.isFxApplicationThread());
    }

    @Override
    protected void cancelled() {
        super.cancelled();
        System.out.println("cancelled :" + Platform.isFxApplicationThread());
    }

    @Override
    protected void failed() {
        super.failed();
        System.out.println("failed :" + Platform.isFxApplicationThread());
    }

    @Override
    protected void executeTask(Task<Number> task) {
        super.executeTask(task);
        task.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("executeTask oldValue : "+ oldValue+" , newValue: "+newValue);
        });

    }

    @Override
    protected Task<Number> createTask() {

        Task<Number> task = new Task() {
            @Override
            protected Number call() throws Exception {
                double total = 100;
                double current = 0;
                while (total>current){
                    //this.getTitle(); 故意出异常
                    if(this.isCancelled()){
                        break;
                    }
                    current++;
                    System.out.println(current/total);
                    this.updateProgress(current,total);
                    if(current%10==0){
                        updateMessage("当前任务进度 : "+current+"%");
                        if(current<total/2){
                            this.updateTitle("任务进行中");
                        }else if(current<total){
                            this.updateTitle("任务快要完成了");
                        }else {
                            this.updateTitle("任务完成了");
                        }
                    }
                    Thread.sleep(100);
                }
                return 0;
            }
        };
        return task;
    }
}