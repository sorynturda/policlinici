package com.example.source.controller;

import com.example.source.Model;
import com.example.source.claseTabele.Programare;
import com.example.source.claseTabele.Raport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

public class SceneRaport {
    private Programare programareSelectata;
    private Raport raportPacient;
    @FXML
    private Label labelPacient;
    @FXML
    private TextField numeTextField;
    @FXML
    private TextField prenumeTextField;
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
    @FXML
    private Button puneParafa;

    public void adaugaServiciu() {
//        String serviciuSelectat = alegeServiciu.getValue();
//        ArrayList<Serviciu> servicii = medicSelectat.getServicii();
//        for (Serviciu s : servicii)
//            if (s.getNume_serviciu().equals(serviciuSelectat))
//                serviciiProgramare.add(s);
    }


    public void setProgramareSelectata(Programare programare) throws SQLException {
        programareSelectata = programare;
        if(Model.getAngajatCurent().getFunctie().equals(Model.ASISTENT_MEDICAL))
            puneParafa.setVisible(false);
        else
            puneParafa.setVisible(true);
        System.out.println(programare);
        raportPacient = Model.extrageRaport(programare.getId());
        if (!raportPacient.getNume_medic_recomandare().isEmpty())
            numeTextField.setText(raportPacient.getNume_medic_recomandare());
        if (!raportPacient.getPrenume_medic_recomandare().isEmpty())
            prenumeTextField.setText(raportPacient.getPrenume_medic_recomandare());
        if (!raportPacient.getIstoric().isEmpty())
            textIstoric.setText(raportPacient.getIstoric());
        if (!raportPacient.getDiagnostic().isEmpty())
            textDiagnostic.setText(raportPacient.getDiagnostic());
        if (!raportPacient.getSimptome().isEmpty())
            textSimptome.setText(raportPacient.getSimptome());
        if (!raportPacient.getRecomandari().isEmpty())
            textRecomandari.setText(raportPacient.getRecomandari());
        labelPacient.setText(programareSelectata.getNume() + " " + programareSelectata.getPrenume());
    }

    public void updateRaport() throws SQLException {
        raportPacient.setNume_medic_recomandare(numeTextField.getText());
        raportPacient.setPrenume_medic_recomandare(prenumeTextField.getText());
        raportPacient.setIstoric(textIstoric.getText());
        raportPacient.setDiagnostic(textDiagnostic.getText());
        raportPacient.setSimptome(textSimptome.getText());
        raportPacient.setRecomandari(textRecomandari.getText());
        Model.updateRaport(raportPacient);
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath;
        if (Model.getAngajatCurent().getFunctie().equals(Model.MEDIC))
            scenePath = "/com.example.source/scene-medic-view.fxml";
        else
            scenePath = "/com.example.source/scene-asistent-medical-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
