package com.example.source.controller;

import com.example.source.HelloApplication;
import javafx.event.ActionEvent;

import java.io.IOException;

public class SceneUser {
    HelloApplication main = new HelloApplication();

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        main.changeScene("scene-login-view.fxml");
    }
}
