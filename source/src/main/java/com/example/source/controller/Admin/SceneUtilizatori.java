package com.example.source.controller.Admin;

import com.example.source.Model;
import com.example.source.claseTabele.Cont;
import com.example.source.claseTabele.Utilizator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class SceneUtilizatori implements Initializable {
    @FXML
    private TextField usernameCTf;
    @FXML
    private TextField passwordTf;
    @FXML
    private TextField cnpTf;
    @FXML
    private TextField numeTf;
    @FXML
    private TextField prenumeTf;
    @FXML
    private DatePicker data_angajariiDP;
    @FXML
    private TextField emailTf;
    @FXML
    private TextField ibanTf;
    @FXML
    private TextField telefonTf;
    @FXML
    private TextField adresaTf;
    @FXML
    private TextField usernameTf;
    @FXML
    private TextField parolaTf;
    @FXML
    private ChoiceBox<String> departamentChoiceBox;
    @FXML
    private ChoiceBox<String> rolChoiceBox;
    @FXML
    private TableView<Utilizator> tabelUtilizatori;
    @FXML
    private TableColumn<Utilizator, Integer> id;
    @FXML
    private TableColumn<Utilizator, Integer> id_cont;
    @FXML
    private TableColumn<Utilizator, String> departament;
    @FXML
    private TableColumn<Utilizator, String> adresa;
    @FXML
    private TableColumn<Utilizator, String> cnp;
    @FXML
    private TableColumn<Utilizator, String> nume;
    @FXML
    private TableColumn<Utilizator, String> prenume;
    @FXML
    private TableColumn<Utilizator, String> telefon;
    @FXML
    private TableColumn<Utilizator, String> email;
    @FXML
    private TableColumn<Utilizator, String> iban;
    @FXML
    private TableColumn<Utilizator, String> data_angajarii;
    @FXML
    private TableColumn<Utilizator, String> rol;
    @FXML
    private TableView<Cont> tabelConturi;
    @FXML
    private TableColumn<Cont, Integer> idC;
    @FXML
    private TableColumn<Cont, String> nume_utilizator;
    @FXML
    private TableColumn<Cont, String> parola;

    String[] departamente = new String[]{"Administratie", "Medical", "Resurse Umane", "Economic"};
    String[] roluri = new String[]{Model.UTILIZATOR, Model.ADMIN, Model.SUPERADMIN};

    ObservableList<Utilizator> utilizatori = FXCollections.observableArrayList();
    ObservableList<Cont> conturi = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTabelUtilizatori();
        populateTabelConturi();
        tabelConturi.setEditable(true);
        nume_utilizator.setCellFactory(TextFieldTableCell.forTableColumn());
        parola.setCellFactory(TextFieldTableCell.forTableColumn());
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

        departamentChoiceBox.setValue(departamente[0]);
        departamentChoiceBox.getItems().addAll(departamente);

        rolChoiceBox.setValue(roluri[0]);
        rolChoiceBox.getItems().addAll(roluri);
    }

    private void populateTabelConturi() {
        conturi = Model.listaConturi();
        idC.setCellValueFactory(new PropertyValueFactory<>("id"));
        nume_utilizator.setCellValueFactory(new PropertyValueFactory<>("nume_utilizator"));
        parola.setCellValueFactory(new PropertyValueFactory<>("parola"));
        tabelConturi.setItems(conturi);
    }

    private void populateTabelUtilizatori() {
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

    public void actualizeazaUtilizatori() {
        ArrayList<Utilizator> u = new ArrayList<>();
        for (Utilizator utilizator : utilizatori) u.add(utilizator.clone());
        Model.actualizeazaUtilizatori(u);
    }

    public void adaugaUtilizator(ActionEvent event) throws IOException {
        Model.adaugaUtilizator(usernameTf.getText(), parolaTf.getText(), departamentChoiceBox.getValue(), adresaTf.getText(), cnpTf.getText(), numeTf.getText(), prenumeTf.getText(), telefonTf.getText(), emailTf.getText(), ibanTf.getText(), Date.valueOf(data_angajariiDP.getValue()), rolChoiceBox.getValue());
    }

    public void actualizeazaConturi() {
        ArrayList<Cont> c = new ArrayList<>();
        for (Cont cont : conturi)
            c.add(cont.clone());
        Model.actualizeazaConturi(c);
    }

    public void stergeUtilizator() {
        Utilizator tmp = tabelUtilizatori.getSelectionModel().getSelectedItem();
        if (tmp != null && !Objects.equals(tmp.getId(), Model.getUtilizatorCurent().getId()))
            Model.stergeUtilizator(tmp.getId(), tmp.getId_cont());
        populateTabelUtilizatori();
    }

    public void adaugaCont() {
        Model.adaugaCont(usernameCTf.getText(), passwordTf.getText());
        populateTabelConturi();
    }

    public void stergeCont() {
        Cont tmp = tabelConturi.getSelectionModel().getSelectedItem();
        if (tmp != null && Model.getUtilizatorCurent().getId_cont() != tmp.getId())
            Model.stergeCont(tmp.getId());
        populateTabelConturi();
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

    public void nume_utilizatorEdit(TableColumn.CellEditEvent<Cont, String> contStringCellEditEvent) {
        tabelConturi.getSelectionModel().getSelectedItem().setNume_utilizator(contStringCellEditEvent.getNewValue());
    }

    public void parolaEdit(TableColumn.CellEditEvent<Cont, String> contStringCellEditEvent) {
        tabelConturi.getSelectionModel().getSelectedItem().setParola(contStringCellEditEvent.getNewValue());
    }

    public void reset(Event event) {
        adresaTf.setText("");
        cnpTf.setText("");
        numeTf.setText("");
        prenumeTf.setText("");
        telefonTf.setText("");
        emailTf.setText("");
        ibanTf.setText("");
        usernameTf.setText("");
        parolaTf.setText("");
        populateTabelUtilizatori();
        populateTabelConturi();
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-super-admin-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }
}
