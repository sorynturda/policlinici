package com.example.source.controller.Receptioner;

import com.example.source.Model;
import com.example.source.claseTabele.Medic;
import com.example.source.claseTabele.Pacient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SceneProgramare implements Initializable {
    @FXML
    private Label labelPacient;
    @FXML
    private Label labelMedic;
    @FXML
    private Button butonInapoi;
    @FXML
    private ChoiceBox<String> alegeMedic;
    private ArrayList<Medic> medici;
    private Pacient pacientSelectat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pacientSelectat = Model.getPacientSelectat();
        try {
            medici = Model.listaMedici();
            creazaCheckBox();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPacientSelectat(Pacient pacient) {
        pacientSelectat = pacient;
        labelPacient.setText(pacient.getNume() + " " + pacient.getPrenume());
    }

    public void alegeMedic(ActionEvent event) {
        labelMedic.setText(alegeMedic.getValue());
        for(Medic m : medici) {
            String nume_prenume = m.getNume() + " " + m.getPrenume();
            if(nume_prenume.equals(labelMedic.getText()))
                m.afiseazaServicii();
        }
    }

    public void creazaCheckBox() {
        alegeMedic.setValue(medici.get(0).getNume() + " " + medici.get(0).getPrenume());
        labelMedic.setText(alegeMedic.getValue());
        medici.get(0).afiseazaServicii();
        String[] nume_medici = new String[medici.size()];
        for (int i = 0; i < medici.size(); i++)
            nume_medici[i] = medici.get(i).getNume() + " " + medici.get(i).getPrenume();
        alegeMedic.getItems().addAll(nume_medici);
        alegeMedic.setOnAction(this::alegeMedic);
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-receptioner-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
