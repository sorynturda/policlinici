package com.example.source.controller;

import com.example.source.Model;
import com.example.source.claseTabele.Angajat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneResurseUmaneOrar implements Initializable {

    @FXML
    private Label labelAngajat;
    @FXML
    private Button butonInapoi;
    @FXML
    private ChoiceBox<String> alegeZi;
    @FXML
    private ChoiceBox<String> oraInceput;
    @FXML
    private ChoiceBox<String> oraSfarsit;
    @FXML
    private Label labelZiSelectata;
    @FXML
    private Label labelOraInceput;
    @FXML
    private Label labelOraSfarsit;
    @FXML
    private Label labelZiInceput;
    @FXML
    private Label labelZiSfarsit;
    @FXML
    private DatePicker concediuInceput;
    @FXML
    private DatePicker concediuSfarsit;

    private String[] zile = new String[]{"Duminica", "Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata"};
    private String[] ore = new String[]{"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"};
    private static int DIFERENTA_ORE = 12;
    private Angajat angajatCurent;

    public void setAngajatCurent(Angajat angajatCurent) {
        this.angajatCurent = angajatCurent;
        labelAngajat.setText(angajatCurent.getNume() + " " + angajatCurent.getPrenume());
        setOrar(angajatCurent.getFunctie().trim().equals("medic"));
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-resurse-umane-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        angajatCurent = Model.getAngajatCurent();
        setOrar(angajatCurent.getFunctie().trim().equals("medic"));
    }

    public void alegeZiua(ActionEvent event) {
        String zi = alegeZi.getValue();
        labelZiSelectata.setText(zi);
        oraInceput.setValue(ore[0]);
        oraSfarsit.setValue(ore[DIFERENTA_ORE]);
    }

    public void setOrar(boolean value) {
        alegeZi.setVisible(value);
        labelZiSelectata.setVisible(value);
        labelOraInceput.setVisible(value);
        labelOraSfarsit.setVisible(value);
        oraSfarsit.setVisible(value);
        oraInceput.setVisible(value);
        if (value) {
            alegeZi.setValue(zile[0]);
            String zi = alegeZi.getValue();
            labelZiSelectata.setText(zi);
            alegeZi.getItems().addAll(zile);
            alegeZi.setOnAction(this::alegeZiua);

            oraInceput.setValue(ore[0]);
            oraInceput.getItems().addAll(ore);
            oraSfarsit.setValue(ore[DIFERENTA_ORE]);
            oraSfarsit.getItems().addAll(ore);
        }
    }
}
