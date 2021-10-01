package com.stark.study.lesson_109;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
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

        Label state = new Label("state");
        Label value = new Label("value");
        Label title = new Label("title");
        Label message = new Label("message");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#EEEEEE");

        hBox.getChildren().addAll(start,cancel,progressBar,state,value,title,message);

        anchorPane.getChildren().addAll(hBox);

        AnchorPane.setTopAnchor(hBox,100.0);
        AnchorPane.setLeftAnchor(hBox, 100.0);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


        MyTask task = new MyTask();


        start.setOnAction(event -> new Thread(task).start());

        cancel.setOnAction(event -> task.cancel());

        task.progressProperty().addListener((observable,oldValue,newValue)->{
            progressBar.setProgress(newValue.doubleValue());
        });

        task.titleProperty().addListener((observable,oldValue,newValue)->{
            title.setText(newValue);
        });

        task.valueProperty().addListener((observable,oldValue,newValue)->{
            value.setText("任务完成");
        });

        task.messageProperty().addListener((observable,oldValue,newValue)->{
            message.setText(newValue);
        });

        task.stateProperty().addListener((observable, oldValue, newValue) -> {
            state.setText(newValue.name());
        });

        task.exceptionProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue.getMessage()));
    }
}

class MyTask extends Task<Number>{

    @Override
    protected Number call() throws Exception {
        this.updateTitle("任务已开始");
        System.out.println(Platform.isFxApplicationThread()+" "+Thread.currentThread().getName()); //表示不是UI线程

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

    @Override
    protected void updateProgress(long workDone, long max) {
        super.updateProgress(workDone, max);
    }

    @Override
    protected void updateProgress(double workDone, double max) {
        super.updateProgress(workDone, max);
    }

    @Override
    protected void updateMessage(String message) {
        super.updateMessage(message);
        System.out.println(message);
    }

    @Override
    protected void updateTitle(String title) {
        super.updateTitle(title);
    }

    @Override
    protected void updateValue(Number value) {
        super.updateValue(value);
        System.out.println(Platform.isFxApplicationThread()+" "+Thread.currentThread().getName());//是UI线程
        System.out.println(value.intValue());
    }

}