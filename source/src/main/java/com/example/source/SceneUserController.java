package com.example.source;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SceneUserController {
    HelloApplication main = new HelloApplication();
    public void switchToSceneLogin(ActionEvent event) throws IOException {
        main.changeScene("scene-login-view.fxml");
    }
}
