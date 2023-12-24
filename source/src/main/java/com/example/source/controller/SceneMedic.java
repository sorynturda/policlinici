package com.example.source.controller;

import com.example.source.Model;
import com.example.source.claseTabele.Specialitati;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SceneMedic implements Initializable {
    @FXML
    private Label labelNume;
    @FXML
    private Label labelPrenume;
    @FXML
    private Label labelDepartament;
    @FXML
    private Label labelAdresa;
    @FXML
    private Label labelCnp;
    @FXML
    private Label labelTelefon;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelIban;
    @FXML
    private Label labelDataAngajarii;
    @FXML
    private Label labelCodParafa;
    @FXML
    private Label labelTitluStiintific;
    @FXML
    private Label labelPostDidactic;
    @FXML
    private Label labelVenitAditional;
    @FXML
    private TableView<Specialitati> tableSpecialitati;
    @FXML
    private TableColumn<Specialitati, String> nume_specialitate;
    @FXML
    private TableColumn<Specialitati, String> grad;
    @FXML
    private Button buttonLogOut;

    ObservableList<Specialitati> specialitati = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelNume.setText(Model.getUtilizatorCurent().getNume());
        labelPrenume.setText(Model.getUtilizatorCurent().getPrenume());
        labelDepartament.setText(Model.getUtilizatorCurent().getDepartament());
        labelAdresa.setText(Model.getUtilizatorCurent().getAdresa());
        labelCnp.setText(Model.getUtilizatorCurent().getCnp());
        labelTelefon.setText(Model.getUtilizatorCurent().getTelefon());
        labelEmail.setText(Model.getUtilizatorCurent().getEmail());
        labelIban.setText(Model.getUtilizatorCurent().getIban());
        labelDataAngajarii.setText(Model.getUtilizatorCurent().getData_angajarii());
        labelCodParafa.setText(Model.getMedicCurent().getCod_parafa());
        labelTitluStiintific.setText(Model.getMedicCurent().getTitlu_stiintific());
        labelPostDidactic.setText(Model.getMedicCurent().getPost_didactic());
        labelVenitAditional.setText(Model.getMedicCurent().getVenit_aditional().toString());
        try {
            specialitati = Model.listaSpecialitatiMedic(Model.getMedicCurent().getId());
            populateTabel();
        } catch (SQLException e) {
            System.out.println("EROARE IN SCENERESURSEUMANE LA INITIALIZARE");
            throw new RuntimeException(e);
        }
    }

    private void populateTabel() {
        nume_specialitate.setCellValueFactory(new PropertyValueFactory<>("nume_specialitate"));
        grad.setCellValueFactory(new PropertyValueFactory<>("grad"));
        tableSpecialitati.setItems(specialitati);
    }

    public void cautaPacient(ActionEvent event) throws IOException {

    }

    public void selecteazaPacient(ActionEvent event) throws IOException {

    }
    public void switchToSceneLogin(ActionEvent event) throws IOException {
        String scene = "/com.example.source/scene-login-view.fxml";
        Model.logOut(event, scene);
    }
}
