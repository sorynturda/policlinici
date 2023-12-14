package com.example.source;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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


    public void switchToSceneUser(ActionEvent event) throws IOException {
        if (textFieldUsername.getText().compareTo("ceva") == 0 && passwordFieldPassword.getText().compareTo("ceva") == 0) {
            Parent root = FXMLLoader.load(getClass().getResource("scene-user-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else if (textFieldUsername.getText().isEmpty() && passwordFieldPassword.getText().isEmpty()) {
            labelErrorLogIn.setText("Introduceti numele de utilizator si parola!");
        }
        else {
            labelErrorLogIn.setText("Nume de utilizator sau parola incorecte!");
        }
    }
}
