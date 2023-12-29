package com.example.source.controller;

import com.example.source.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class SceneRaport {
    @FXML
    private Label labelPacient;
    @FXML
    private TextArea textIstoric;
    @FXML
    private TextArea textSimptome;
    @FXML
    private TextArea textDiagnostic;
    @FXML
    private TextArea textRecomandari;
    @FXML
    private ChoiceBox<String> alegeServiciu;
    @FXML
    private TextArea textInvestigatii;

    public void adaugaServiciu() {
//        String serviciuSelectat = alegeServiciu.getValue();
//        ArrayList<Serviciu> servicii = medicSelectat.getServicii();
//        for (Serviciu s : servicii)
//            if (s.getNume_serviciu().equals(serviciuSelectat))
//                serviciiProgramare.add(s);
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-medic-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
