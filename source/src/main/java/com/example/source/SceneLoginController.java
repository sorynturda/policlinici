package com.example.source;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class SceneLoginController {
    HelloApplication main = new HelloApplication();

    @FXML
    private Label labelErrorLogIn;
    @FXML
    private TextField textFieldUsername;
    @FXML
    private PasswordField passwordFieldPassword;
    @FXML
    private Button buttonLogIn;

    public SceneLoginController() {
    }


    public void switchToSceneUser(ActionEvent event) throws IOException, SQLException {
        if(Model.extrageContUtilizator(textFieldUsername.getText(), passwordFieldPassword.getText())) {
            main.changeScene("scene-user-view.fxml");
        }else if (textFieldUsername.getText().isEmpty() && passwordFieldPassword.getText().isEmpty()) {
            labelErrorLogIn.setText("Introduceti numele de utilizator si parola!");
        }
        else {
            labelErrorLogIn.setText("Nume de utilizator sau parola incorecte!");
        }
    }
}
