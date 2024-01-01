package com.example.source.controller.Admin;

import com.example.source.Model;
import com.example.source.claseTabele.Utilizator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneUtilizatori implements Initializable {
    @FXML
    TableView<Utilizator> tabelUtilizatori;
    @FXML
    TableColumn<Utilizator, Integer> id;
    @FXML
    TableColumn<Utilizator, Integer> id_cont;
    @FXML
    TableColumn<Utilizator, String> departament;
    @FXML
    TableColumn<Utilizator, String> adresa;
    @FXML
    TableColumn<Utilizator, String> cnp;
    @FXML
    TableColumn<Utilizator, String> nume;
    @FXML
    TableColumn<Utilizator, String> prenume;
    @FXML
    TableColumn<Utilizator, String> telefon;
    @FXML
    TableColumn<Utilizator, String> email;
    @FXML
    TableColumn<Utilizator, String> iban;
    @FXML
    TableColumn<Utilizator, String> data_angajarii;
    @FXML
    TableColumn<Utilizator, String> rol;

    ObservableList<Utilizator> utilizatori = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTabel();
        tabelUtilizatori.setEditable(true);
        departament.setCellFactory(TextFieldTableCell.forTableColumn());
        adresa.setCellFactory(TextFieldTableCell.forTableColumn());
        cnp.setCellFactory(TextFieldTableCell.forTableColumn());
        nume.setCellFactory(TextFieldTableCell.forTableColumn());
        prenume.setCellFactory(TextFieldTableCell.forTableColumn());
        telefon.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        iban.setCellFactory(TextFieldTableCell.forTableColumn());
        data_angajarii.setCellFactory(TextFieldTableCell.forTableColumn());
        rol.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void populateTabel() {
        utilizatori = Model.listaUtilizatori();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_cont.setCellValueFactory(new PropertyValueFactory<>("id_cont"));
        departament.setCellValueFactory(new PropertyValueFactory<>("departament"));
        adresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        cnp.setCellValueFactory(new PropertyValueFactory<>("cnp"));
        nume.setCellValueFactory(new PropertyValueFactory<>("nume"));
        prenume.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        telefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        iban.setCellValueFactory(new PropertyValueFactory<>("iban"));
        data_angajarii.setCellValueFactory(new PropertyValueFactory<>("data_angajarii"));
        rol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        tabelUtilizatori.setItems(utilizatori);
    }

    public void actualizeaza(){
        Utilizator u = tabelUtilizatori.getSelectionModel().getSelectedItem();
        if(u != null)
            System.out.println(u);
    }

    public void departamentEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setDepartament(utilizatorStringCellEditEvent.getNewValue());
    }

    public void adresaEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setAdresa(utilizatorStringCellEditEvent.getNewValue());
    }

    public void cnpEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setCnp(utilizatorStringCellEditEvent.getNewValue());
    }

    public void numeEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setNume(utilizatorStringCellEditEvent.getNewValue());
    }

    public void prenumeEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setPrenume(utilizatorStringCellEditEvent.getNewValue());
    }

    public void telefonEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setTelefon(utilizatorStringCellEditEvent.getNewValue());
    }

    public void emailEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setEmail(utilizatorStringCellEditEvent.getNewValue());
    }

    public void ibanEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setIban(utilizatorStringCellEditEvent.getNewValue());
    }

    public void data_angajariiEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setData_angajarii(utilizatorStringCellEditEvent.getNewValue());
    }

    public void rolEdit(TableColumn.CellEditEvent<Utilizator, String> utilizatorStringCellEditEvent) {
        tabelUtilizatori.getSelectionModel().getSelectedItem().setRol(utilizatorStringCellEditEvent.getNewValue());
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-super-admin-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
