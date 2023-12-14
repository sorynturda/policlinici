package com.example.source;

import java.sql.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.PropertySheet;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage currentStage;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        try {
            currentStage = stage;
            stage.setResizable(false);
            Parent root = FXMLLoader.load(getClass().getResource("scene-login-view.fxml"));
            stage.setTitle("Policlinici");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Model model = new Model();
    }

    public void changeScene(String fxml) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fxml));
        currentStage.getScene().setRoot(parent);
    }

    public static void main(String[] args) {
        launch();
    }
}