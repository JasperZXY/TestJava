package com.jasper.JDK8.javafx;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.util.Date;

public class Controller1 {
    @FXML
    private Text text1;
    @FXML
    private Text text2;

    @FXML
    public void onBn1Listener(Event event) {
        text1.setText(event.getEventType().getName());
        text2.setText(new Date().toString());
    }
}
