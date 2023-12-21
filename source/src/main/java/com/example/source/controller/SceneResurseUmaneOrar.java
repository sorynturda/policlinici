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
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.time.temporal.ChronoUnit.DAYS;

public class SceneResurseUmaneOrar implements Initializable {

    @FXML
    private Label labelAngajat;
    @FXML
    private Button butonInapoi;
    @FXML
    private Button butonConcediu;
    @FXML
    private Button butonOrar;
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
    private Label labelConfirmareConcediu;
    @FXML
    private DatePicker concediuInceput;
    @FXML
    private DatePicker concediuSfarsit;
    private String[] zile = new String[] {"Duminica", "Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata"};
    private String[] ore = new String[] {"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"};
    private static int DIFERENTA_ORE = 12;
    private static int ZILE_MAXIME_CONCEDIU = 14;
    private Angajat angajatCurent;

    public void setAngajatCurent(Angajat angajatCurent) {
        this.angajatCurent = angajatCurent;
        labelAngajat.setText(angajatCurent.getFunctie() + ": " + angajatCurent.getNume() + " " + angajatCurent.getPrenume());
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
        labelConfirmareConcediu.setText("");
    }

    public void alegeZiua(ActionEvent event) {
        String zi = alegeZi.getValue();
        labelZiSelectata.setText(zi);
        oraInceput.setValue(ore[0]);
        oraSfarsit.setValue(ore[DIFERENTA_ORE]);
    }

    public void butonConcediuApasat(ActionEvent event) {
        LocalDate ziInceput = concediuInceput.getValue();
        LocalDate ziSfarsit = concediuSfarsit.getValue();
        long nrZileConcediu = DAYS.between(ziInceput, ziSfarsit);
        if (ziSfarsit.isAfter(ziInceput) && (int) nrZileConcediu <= ZILE_MAXIME_CONCEDIU){
            System.out.println(ziInceput + "\n" + ziSfarsit);
            System.out.println(nrZileConcediu);
            if(Model.concediuCorect(angajatCurent.getId(), Date.valueOf(ziInceput), Date.valueOf(ziSfarsit))) {
                Model.adaugaConcediu(angajatCurent.getId(), ziInceput, ziSfarsit);
                labelConfirmareConcediu.setText("Succes!");
            }
            else{
                labelConfirmareConcediu.setText("Eroare");
            }
        }
    }

    public void butonOrarApasat(ActionEvent event) {
        System.out.println("orar: " + angajatCurent);
    }

    public void setOrar(boolean value) {
        labelConfirmareConcediu.setText("");

        alegeZi.setVisible(value);
        labelZiSelectata.setVisible(value);
        labelOraInceput.setVisible(value);
        labelOraSfarsit.setVisible(value);
        oraSfarsit.setVisible(value);
        oraInceput.setVisible(value);
        butonOrar.setVisible(value);
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
