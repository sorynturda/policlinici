package com.example.source.controller.Admin;

import com.example.source.Model;
import com.example.source.claseTabele.Policlinica;
import com.example.source.claseTabele.ProgramFunctionare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ScenePoliclinici implements Initializable {
    @FXML
    private TableView<Policlinica> tabelPoliclinici;
    @FXML
    private TableColumn<Policlinica, Integer> id;
    @FXML
    private TableColumn<Policlinica, Integer> id_program_functionare;
    @FXML
    private TableColumn<Policlinica, String> adresa;
    @FXML
    private TableColumn<Policlinica, String> denumire;
    @FXML
    private TableView<ProgramFunctionare> tabelProgram;
    @FXML
    private TableColumn<ProgramFunctionare, Integer> idP;
    @FXML
    private TableColumn<ProgramFunctionare, String> duminica;
    @FXML
    private TableColumn<ProgramFunctionare, String> luni;
    @FXML
    private TableColumn<ProgramFunctionare, String> marti;
    @FXML
    private TableColumn<ProgramFunctionare, String> miercuri;
    @FXML
    private TableColumn<ProgramFunctionare, String> joi;
    @FXML
    private TableColumn<ProgramFunctionare, String> vineri;
    @FXML
    private TableColumn<ProgramFunctionare, String> sambata;
    ObservableList<Policlinica> policlinici = FXCollections.observableArrayList();
    ObservableList<ProgramFunctionare> program = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTabelPoliclinici();
        populateTabelProgram();
        tabelProgram.setEditable(true);
        duminica.setCellFactory(TextFieldTableCell.forTableColumn());
        luni.setCellFactory(TextFieldTableCell.forTableColumn());
        marti.setCellFactory(TextFieldTableCell.forTableColumn());
        miercuri.setCellFactory(TextFieldTableCell.forTableColumn());
        joi.setCellFactory(TextFieldTableCell.forTableColumn());
        vineri.setCellFactory(TextFieldTableCell.forTableColumn());
        sambata.setCellFactory(TextFieldTableCell.forTableColumn());
        tabelPoliclinici.setEditable(true);
        id_program_functionare.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        denumire.setCellFactory(TextFieldTableCell.forTableColumn());
        adresa.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void populateTabelProgram() {
        program = Model.listaProgramFunctionare();
        idP.setCellValueFactory(new PropertyValueFactory<>("id"));
        duminica.setCellValueFactory(new PropertyValueFactory<>("duminica"));
        luni.setCellValueFactory(new PropertyValueFactory<>("luni"));
        marti.setCellValueFactory(new PropertyValueFactory<>("marti"));
        miercuri.setCellValueFactory(new PropertyValueFactory<>("miercuri"));
        joi.setCellValueFactory(new PropertyValueFactory<>("joi"));
        vineri.setCellValueFactory(new PropertyValueFactory<>("vineri"));
        sambata.setCellValueFactory(new PropertyValueFactory<>("sambata"));
        tabelProgram.setItems(program);
    }

    private void populateTabelPoliclinici() {
        policlinici = Model.listPoliclinici();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_program_functionare.setCellValueFactory(new PropertyValueFactory<>("id_program_functionare"));
        adresa.setCellValueFactory(new PropertyValueFactory<>("adresa"));
        denumire.setCellValueFactory(new PropertyValueFactory<>("denumire"));
        tabelPoliclinici.setItems(policlinici);
    }

    public void update(){
        ArrayList<ProgramFunctionare> pr = new ArrayList<>();
        ArrayList <Policlinica> po = new ArrayList<>();
        for(ProgramFunctionare progr : program)
            pr.add(progr.clone());
        for(Policlinica pol : policlinici)
            po.add(pol.clone());
        Model.actualizeazaPoliclinici(pr, po);
    }

    public void goBack(ActionEvent event) throws IOException {
        String scenePath = "/com.example.source/scene-super-admin-view.fxml";
        Model.goToMainMenu(event, scenePath);
    }

    public void id_program_functionareEdit(TableColumn.CellEditEvent<Policlinica, Integer> policlinicaIntegerCellEditEvent) {
        tabelPoliclinici.getSelectionModel().getSelectedItem().setId_program_functionare(policlinicaIntegerCellEditEvent.getNewValue());
    }
    public void adresaEdit(TableColumn.CellEditEvent<Policlinica, String> policlinicaIntegerCellEditEvent) {
        tabelPoliclinici.getSelectionModel().getSelectedItem().setAdresa(policlinicaIntegerCellEditEvent.getNewValue());
    }
    public void denumireEdit(TableColumn.CellEditEvent<Policlinica, String> policlinicaIntegerCellEditEvent) {
        tabelPoliclinici.getSelectionModel().getSelectedItem().setDenumire(policlinicaIntegerCellEditEvent.getNewValue());
    }

    public void duminicaEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setDuminica(programFunctionareStringCellEditEvent.getNewValue());
    }

    public void luniEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setLuni(programFunctionareStringCellEditEvent.getNewValue());
    }

    public void martiEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setMarti(programFunctionareStringCellEditEvent.getNewValue());
    }

    public void miercuriEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setMiercuri(programFunctionareStringCellEditEvent.getNewValue());
    }

    public void joiEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setJoi(programFunctionareStringCellEditEvent.getNewValue());
    }

    public void vineriEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setVineri(programFunctionareStringCellEditEvent.getNewValue());
    }

    public void sambataEdit(TableColumn.CellEditEvent<ProgramFunctionare, String> programFunctionareStringCellEditEvent) {
        tabelProgram.getSelectionModel().getSelectedItem().setSambata(programFunctionareStringCellEditEvent.getNewValue());
    }
}
