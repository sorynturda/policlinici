package com.example.source.claseTabele;

import com.example.source.Model;

import java.util.ArrayList;

public class Medic {
    private Integer id;
    private Integer id_angajat;
    private String cod_parafa;
    private String titlu_stiintific;
    private String post_didactic;
    private Double venit_aditional;
    private String nume; //am adaugat nume si prenume sa nu mai caut inca o data in baza de date
    private String prenume;
    private ArrayList<Serviciu> servicii;

    public Medic(Integer id, Integer id_angajat, String cod_parafa, String titlu_stiintific, String post_didactic, Double venit_aditional, String nume, String prenume) {
        this.id = id;
        this.id_angajat = id_angajat;
        this.cod_parafa = cod_parafa;
        this.titlu_stiintific = titlu_stiintific;
        this.post_didactic = post_didactic;
        this.venit_aditional = venit_aditional;
        this.nume = nume;
        this.prenume = prenume;
        this.servicii = Model.cautaServiciiMedic((int) id);
    }

    public Medic(Integer id, String cod_parafa, String titlu_stiintific, String post_didactic, Double venit_aditional) {
        this.id = id;
        this.cod_parafa = cod_parafa;
        this.titlu_stiintific = titlu_stiintific;
        this.post_didactic = post_didactic;
        this.venit_aditional = venit_aditional;
    }

    public Integer getId() {
        return id;
    }

    public String getCod_parafa() {
        return cod_parafa;
    }

    public String getTitlu_stiintific() {
        return titlu_stiintific;
    }

    public String getPost_didactic() {
        return post_didactic;
    }

    public Double getVenit_aditional() {
        return venit_aditional;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Integer getId_angajat() {
        return id_angajat;
    }

    public void afiseazaServicii() {
        for (Serviciu s : servicii)
            System.out.println(s.toString());
    }

    public ArrayList<Serviciu> getServicii() {
        return servicii;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "id=" + id +
                ", cod_parafa='" + cod_parafa + '\'' +
                ", titlu_stiintific='" + titlu_stiintific + '\'' +
                ", post_didactic='" + post_didactic + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", venit_aditional=" + venit_aditional +
                '}';
    }
}
