package com.example.source.controller.Receptioner;

import com.example.source.Model;
import com.example.source.claseTabele.Pacient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SceneMain implements Initializable {
    @FXML
    private TextField inputTextField;
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
    private Button buttonLogOut;
    @FXML
    private TableView<Pacient> tabel;
    @FXML
    private TableColumn<Pacient, Integer> id;
    @FXML
    private TableColumn<Pacient, String> nume;
    @FXML
    private TableColumn<Pacient, String> prenume;
    ObservableList<Pacient> pacienti = FXCollections.observableArrayList();

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
        try {
            pacienti = Model.listaPacienti();
            populateTabel();
        } catch (SQLException e) {
            System.out.println("EROARE LA RECEPTIONER IN MAIN WINDOW");
            throw new RuntimeException(e);
        }
    }

    private void populateTabel() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        tabel.setItems(pacienti);
    }

    public void selecteazaPacient(ActionEvent event) throws IOException {
        Pacient pacient = tabel.getSelectionModel().getSelectedItem();
        System.out.println(pacient);
        try {
            Model.switchToWindowProgramare(event, pacient);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    public void cautaPacient(ActionEvent event) throws IOException, SQLException {
        String input = inputTextField.getText().trim();
        if (!input.isEmpty()) {
            pacienti = Model.cautaPacient(input);
            populateTabel();
        } else {
            pacienti = Model.listaPacienti();
            populateTabel();
        }
    }

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        String scene = "/com.example.source/scene-login-view.fxml";
        Model.logOut(event, scene);
    }
}
