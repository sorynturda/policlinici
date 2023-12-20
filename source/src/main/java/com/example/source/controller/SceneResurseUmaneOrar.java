package com.example.source.controller;

import com.example.source.Model;
import com.example.source.claseTabele.Angajat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class SceneResurseUmaneOrar {

    @FXML
    private Label labelAngajat;
    @FXML
    private Button butonInapoi;
    private Angajat angajatCurent;

    public void setAngajatCurent(Angajat angajatCurent) {
        this.angajatCurent = angajatCurent;
        labelAngajat.setText(angajatCurent.getNume() + " " + angajatCurent.getPrenume());
    }

    public void goBack(ActionEvent event) throws IOException{
        String scenePath = "/com.example.source/scene-resurse-umane-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
