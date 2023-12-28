package com.example.source.controller;

import com.example.source.Model;
import com.example.source.claseTabele.DataConcediu;
import com.example.source.claseTabele.OrarAngajat;
import com.example.source.claseTabele.Pacient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class SceneAsistentMedical implements Initializable {
    @FXML
    private Label labelNume;
    @FXML
    private Label labelPrenume;
    @FXML
    private Label labelDepartament;
    @FXML
    private Label labelAdresa;
    @FXML
    private Label labelCnp;
    @FXML
    private Label labelTelefon;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelIban;
    @FXML
    private Label labelDataAngajarii;
    @FXML
    private Label labelTip;
    @FXML
    private Label labelGrad;
    @FXML
    private Label labelLocatie;
    @FXML
    private Button buttonLogOut;
    @FXML
    private TextField cautaPacientProgramatTextField;
    @FXML
    private ChoiceBox<String> alegeLuna;
    @FXML
    private ChoiceBox<String> alegeAn;
    @FXML
    private TableView<OrarAngajat> tabelOrar;
    @FXML
    private TableColumn<OrarAngajat, Integer> coloanaZi;
    @FXML
    private TableColumn<OrarAngajat, String> coloanaInterval;
    @FXML
    private TableView<Pacient> tabelPacientiProgramati;
    @FXML
    private TableColumn<Pacient, String> numePacientProgramare;
    @FXML
    private TableColumn<Pacient, String> prenumePacientProgramare;
    private String[] luni = new String[]{"Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie",
            "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"};
    ObservableList<OrarAngajat> orar = FXCollections.observableArrayList();
    ObservableList<Pacient> pacientiProgramati = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelNume.setText(Model.getUtilizatorCurent().getNume());
        labelPrenume.setText(Model.getUtilizatorCurent().getPrenume());
        labelDepartament.setText(Model.getUtilizatorCurent().getDepartament());
        labelAdresa.setText(Model.getUtilizatorCurent().getAdresa());
        labelCnp.setText(Model.getUtilizatorCurent().getCnp());
        labelTelefon.setText(Model.getUtilizatorCurent().getTelefon());
        labelEmail.setText(Model.getUtilizatorCurent().getEmail());
        labelIban.setText(Model.getUtilizatorCurent().getIban());
        labelDataAngajarii.setText(Model.getUtilizatorCurent().getData_angajarii());
        labelTip.setText(Model.getAsistentCurent().getTip());
        labelGrad.setText(Model.getAsistentCurent().getGrad());
        labelLocatie.setText(Model.getUtilizatorCurent().getAdresa());
        setAlegeLunaAn();
    }

    private void populateTabelConcediu() {
        coloanaZi.setCellValueFactory(new PropertyValueFactory<>("zi"));
        coloanaInterval.setCellValueFactory(new PropertyValueFactory<>("interval"));
        tabelOrar.setItems(orar);
    }

    private void setAlegeLunaAn() {
        alegeLuna.setValue(luni[0]);
        alegeLuna.getItems().addAll(luni);
        int anCurent = LocalDate.now().getYear();
        alegeAn.setValue(Integer.toString(anCurent));
        alegeAn.getItems().addAll(new String[]{Integer.toString(anCurent), Integer.toString(anCurent + 1)});
    }

    public void afiseazaOrar() {
        int policlinica = Model.getAngajatCurent().getId_policlinica();
        ArrayList<String> orarString = Model.orarPoliclinica(policlinica);
        String luna = alegeLuna.getValue();
        int numarLuna = getNumarLuna(luna);
        int an = Integer.parseInt(alegeAn.getValue());
        LocalDate data = LocalDate.of(an, numarLuna, 1);
        HashMap<String, String> H = faHashMap(orarString);
        orar.clear();
        for (int i = 1; i <= data.lengthOfMonth(); i++)
            orar.add(new OrarAngajat(i, H.get(LocalDate.of(an, numarLuna, i).getDayOfWeek().toString())));
        puneConcediuInOrar(data);
        populateTabelConcediu();
    }

    private int getNumarLuna(String luna) {
        for (int i = 0; i < 12; i++)
            if (luni[i].equals(luna))
                return i + 1;
        return 1;
    }

    private void puneConcediuInOrar(LocalDate data) {
        ArrayList<DataConcediu> concedii = Model.angajatInConcediu(Model.getAngajatCurent().getId());
        for (DataConcediu it : concedii) {
            LocalDate data_inceput = it.getData_inceput().toLocalDate();
            LocalDate data_sfarsit = it.getData_sfarsit().toLocalDate();
            if (data_sfarsit.getYear() == data_inceput.getYear() && data.getYear() == data_inceput.getYear()) {
                if (data_sfarsit.getMonth() == data_inceput.getMonth() && data_sfarsit.getMonth() == data.getMonth())
                    for (int i = data_inceput.getDayOfMonth() - 1; i < data_sfarsit.getDayOfMonth(); i++)
                        orar.set(i, new OrarAngajat(i + 1, "CONCEDIU"));
                else {
                    if (data_inceput.getMonth() != data_sfarsit.getMonth()) {
                        if (data_inceput.getMonth() == data.getMonth())
                            for (int i = data_inceput.getDayOfMonth() - 1; i < data.lengthOfMonth(); i++)
                                orar.set(i, new OrarAngajat(i + 1, "CONCEDIU"));
                        if (data_sfarsit.getMonth() == data.getMonth())
                            for (int i = 0; i < data_sfarsit.getDayOfMonth(); i++)
                                orar.set(i, new OrarAngajat(i + 1, "CONCEDIU"));
                    }
                }
            } else {
                if (data_inceput.getYear() == data.getYear() && data_inceput.getMonth() == data.getMonth())
                    for (int i = data_inceput.getDayOfMonth() - 1; i < data.lengthOfMonth(); i++)
                        orar.set(i, new OrarAngajat(i + 1, "CONCEDIU"));
                if (data_sfarsit.getYear() == data.getYear() && data_sfarsit.getMonth() == data.getMonth())
                    for (int i = 0; i < data_sfarsit.getDayOfMonth(); i++)
                        orar.set(i, new OrarAngajat(i + 1, "CONCEDIU"));
            }
        }
    }

    private HashMap<String, String> faHashMap(ArrayList<String> orar) {
        HashMap<String, String> H = new HashMap<>();
        H.put("SUNDAY", orar.get(0));
        H.put("MONDAY", orar.get(1));
        H.put("TUESDAY", orar.get(2));
        H.put("WEDNESDAY", orar.get(3));
        H.put("THURSDAY", orar.get(4));
        H.put("FRIDAY", orar.get(5));
        H.put("SATURDAY", orar.get(6));
        return H;
    }

    public void afiseazaPacientiProgramatiAzi() {
        pacientiProgramati.clear();
        pacientiProgramati = Model.pacientiProgramatAziLaPoliclinica(Model.getAngajatCurent().getId_policlinica());
        populateTabelPacientiProgramati();
    }

    public void afiseazaPacientiProgramati() {
        pacientiProgramati.clear();
        String text = cautaPacientProgramatTextField.getText();
        if (text.isEmpty())
            pacientiProgramati = Model.pacientiProgramati(Model.getAngajatCurent().getId_policlinica());
        else
            switch (text.split(" ").length) {
                case 1:
                    pacientiProgramati = Model.pacientiProgramati(Model.getAngajatCurent().getId_policlinica(), text.split(" ")[0]);
                    break;
                case 2:
                    pacientiProgramati = Model.pacientiProgramati(Model.getAngajatCurent().getId_policlinica(), text.split(" ")[0], text.split(" ")[1]);
                    break;
                default:
                    System.out.println("DOAR DOUA CUVINTE");
                    break;
            }
        populateTabelPacientiProgramati();
    }

    private void populateTabelPacientiProgramati() {
        numePacientProgramare.setCellValueFactory(new PropertyValueFactory<>("nume"));
        prenumePacientProgramare.setCellValueFactory(new PropertyValueFactory<>("prenume"));
        tabelPacientiProgramati.setItems(pacientiProgramati);
    }

    public void switchToSceneLogin(ActionEvent event) throws IOException {
        String scene = "/com.example.source/scene-login-view.fxml";
        Model.logOut(event, scene);
    }
}
