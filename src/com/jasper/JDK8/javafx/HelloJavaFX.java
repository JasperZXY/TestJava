package com.jasper.JDK8.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by zxy on 2017/7/2.
 */
public class HelloJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Hello, JavaFX!");
        label.setFont(new Font(100));
        primaryStage.setScene(new Scene(label));
        primaryStage.setTitle("JavaFX");
        primaryStage.show();
    }
}
