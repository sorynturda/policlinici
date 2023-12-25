package com.example.source.controller.Receptioner;

import com.example.source.claseTabele.DataConcediu;
import com.example.source.Model;
import com.example.source.claseTabele.Medic;
import com.example.source.claseTabele.Pacient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SceneProgramare implements Initializable {
    @FXML
    private Label labelPacient;
    @FXML
    private Label labelMedic;
    @FXML
    private DatePicker dataProgramare;
    @FXML
    private ChoiceBox<String> alegeMedic;
    @FXML
    private ChoiceBox<String> alegeOra;
    private ArrayList<Medic> medici;
    private Medic medicSelectat;
    private Pacient pacientSelectat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pacientSelectat = Model.getPacientSelectat();
        dataProgramare.setDayCellFactory(picker -> new DateCell() { //date de azi incolo
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate azi = LocalDate.now();
                setDisable(empty || date.compareTo(azi) < 0);
            }
        });
        try {
            medici = Model.listaMedici();
            creazaCheckBoxMedici();
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
        for (Medic m : medici) {
            String nume_prenume = m.getNume() + " " + m.getPrenume();
            if (nume_prenume.equals(labelMedic.getText()))
                medicSelectat = m;
        }
        restrictieData();
    }

    public void creazaCheckBoxMedici() {
        alegeMedic.setValue(medici.get(0).getNume() + " " + medici.get(0).getPrenume());
        labelMedic.setText(alegeMedic.getValue());
        medici.get(0).afiseazaServicii();
        medicSelectat = medici.get(0);
        String[] nume_medici = new String[medici.size()];
        for (int i = 0; i < medici.size(); i++)
            nume_medici[i] = medici.get(i).getNume() + " " + medici.get(i).getPrenume();
        alegeMedic.getItems().addAll(nume_medici);
        alegeMedic.setOnAction(this::alegeMedic);
        restrictieData();
    }

    private void restrictieData() {
        ArrayList<DataConcediu> concedii = Model.medicInConcediu(medicSelectat.getId_angajat());
        dataProgramare.setDayCellFactory(picker -> new DateCell() { //date de azi incolo
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                for (DataConcediu c : concedii) {
                    LocalDate data_inceput = c.getData_inceput().toLocalDate();
                    LocalDate data_sfarsit = c.getData_sfarsit().toLocalDate();
                    setDisable(empty || (date.compareTo(data_inceput) >= 0 && date.compareTo(data_sfarsit) <= 0));
                }
            }
        });
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-receptioner-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
