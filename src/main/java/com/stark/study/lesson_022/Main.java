package com.stark.study.lesson_022;

import javafx.application.Application;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage){

        Button button = new Button("点击显示窗口");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-background-color:#FFFFFF");
        anchorPane.getChildren().addAll(button);

        AnchorPane.setLeftAnchor(button,100.0);
        AnchorPane.setTopAnchor(button,100.0);
        Scene scene = new Scene(anchorPane);


        button.setOnAction(event -> {
            System.out.println("点击事件");

            DialogPane dialogPane =new DialogPane();

            dialogPane.setHeaderText("HeaderText");
            dialogPane.setContentText("ContentText");

            dialogPane.getButtonTypes().addAll(ButtonType.APPLY,
                    ButtonType.CANCEL,
                    ButtonType.PREVIOUS);
            dialogPane.setExpandableContent(new Text("ExpandableContent"));
            dialogPane.setExpanded(false);

//            dialogPane.setGraphic(new Button("Graphic"));
            ImageView imageView = new ImageView("icon//icon.gif");
            dialogPane.setGraphic(imageView);

            Button apply = (Button) dialogPane.lookupButton(ButtonType.APPLY);
            Button cancel = (Button) dialogPane.lookupButton(ButtonType.CANCEL);

            apply.setOnAction(event1 -> {
                System.out.println("Apply");
            });
            cancel.setOnAction(event1 -> {
                System.out.println("Cancel");
            });

            Stage stage = new Stage();
            stage.setTitle("这是对话框窗口");
            stage.initOwner(primaryStage);
            stage.initStyle(StageStyle.UTILITY);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.setResizable(false);


            Scene scene1 = new Scene(dialogPane);
            stage.setScene(scene1);

            stage.show();


            MyScheduleService scheduleService = new MyScheduleService(dialogPane,stage);
            scheduleService.setDelay(Duration.millis(0));
            scheduleService.setPeriod(Duration.millis(1000));
            scheduleService.start();

        });

        primaryStage.setScene(scene);
        primaryStage.setHeight(600);
        primaryStage.setWidth(800);
        primaryStage.setTitle("JavaFX");

        primaryStage.show();

    }
}

class MyScheduleService extends ScheduledService<Integer>{

    private DialogPane dialogPane;
    private Stage stage;
    private Integer value = 0;

    public MyScheduleService(DialogPane dialogPane,Stage stage){
        this.dialogPane = dialogPane;
        this.stage = stage;
    }


    @Override
    protected Task<Integer> createTask() {
        return new Task<Integer>() {
            @Override
            protected Integer call() throws Exception {

                System.out.println("call thread :" +Thread.currentThread().getName());
                return value++;
            }

            @Override
            protected void updateValue(Integer value) {
                super.updateValue(value);
                System.out.println("updateValue thread :" +Thread.currentThread().getName());
                System.out.println("updateValue value :" +value);

                if(value < 11){
                    dialogPane.setContentText("current : "+value);
                }else {
                    MyScheduleService.this.cancel();
                    stage.close();
                }
            }
        };
    }
}