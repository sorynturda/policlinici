package com.example.source.controller;

import com.example.source.HelloApplication;
import com.example.source.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class SceneLogin {
    HelloApplication main = new HelloApplication();
    @FXML
    private Label labelErrorLogIn;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField passwordFieldPassword;
    @FXML
    private Button buttonLogIn;

    public SceneLogin() {
    }


    public void switchToSceneUser(ActionEvent event) throws IOException, SQLException {
        if (Model.extrageContUtilizator(textFieldUsername.getText(), passwordFieldPassword.getText())) {
            if (textFieldUsername.getText().equals("resurseumane"))
                main.changeScene("scene-resurse-umane-view.fxml");
            else
                main.changeScene("scene-user-view.fxml");
        } else if (textFieldUsername.getText().isEmpty() && passwordFieldPassword.getText().isEmpty()) {
            labelErrorLogIn.setText("Introduceti numele de utilizator si parola!");
        } else {
            labelErrorLogIn.setText("Nume de utilizator sau parola incorecte!");
        }
    }
}
