package com.example.source.controller;

import com.example.source.Angajat;
import com.example.source.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SceneResurseUmane {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField inputTextField;
    @FXML
    private TableView<Angajat> tabel;
    @FXML
    private TableColumn<Angajat, Integer> id;
    @FXML
    private TableColumn<Angajat, Integer> id_utilizator;
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
            populateTabel();
        } else {
            angajati = Model.listaAngajati();
            populateTabel();
        }
    }

    private void populateTabel() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_utilizator.setCellValueFactory(new PropertyValueFactory<>("id_utilizator"));
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        functie.setCellValueFactory(new PropertyValueFactory<>("functie"));
        tabel.setItems(angajati);
    }

    public void functie(ActionEvent event) throws IOException {
        Angajat a = tabel.getSelectionModel().getSelectedItem();
        System.out.println(a);
    }

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com.example.source/scene-login-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
