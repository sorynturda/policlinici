package com.example.source.controller.Admin;

import com.example.source.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSuperAdmin {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void goToUtilizatori(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.example.source/scene-sa-utilizatori-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        String scene = "/com.example.source/scene-login-view.fxml";
        Model.logOut(event, scene);
    }
}
