package com.example.source;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class SceneResurseUmaneController {
    HelloApplication main = new HelloApplication();
    @FXML
    private TextField inputTextField;
    @FXML
    private TableView<Angajat> tabel;
    @FXML
    private TableColumn<Angajat, String> nume;
    @FXML
    private TableColumn<Angajat, String> prenume;
    @FXML
    private TableColumn<Angajat, String> functie;
    ObservableList<Angajat> angajati = FXCollections.observableArrayList();

    public void cautaAngajat(ActionEvent event) throws IOException, SQLException {
        String input = inputTextField.getText().trim();
        if (!input.isEmpty()) {
            angajati = Model.cautaAngajat(input);
            nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
            prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
            functie.setCellValueFactory(new PropertyValueFactory<>("functie"));
            tabel.setItems(angajati);
        }
    }

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        main.changeScene("scene-login-view.fxml");
    }
}
