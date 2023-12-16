package com.example.source.controller;

import com.example.source.Model;
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
import java.sql.SQLException;

public class SceneLogin {
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

    public void switchToSceneUser(ActionEvent event) throws IOException, SQLException {
        if (Model.extrageContUtilizator(textFieldUsername.getText(), passwordFieldPassword.getText())) {
            if (textFieldUsername.getText().equals("resurseumane")) {
                switchToSceneResurseUmane(event);
            } else {
                switchToSceneMedic(event);
            }
        } else if (textFieldUsername.getText().isEmpty() && passwordFieldPassword.getText().isEmpty()) {
            labelErrorLogIn.setText("Introduceti numele de utilizator si parola!");
        } else {
            labelErrorLogIn.setText("Nume de utilizator sau parola incorecte!");
        }
    }

    private void switchToSceneMedic(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.example.source/scene-user-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneResurseUmane(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.example.source/scene-resurse-umane-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
