package com.example.source.claseTabele;

import java.sql.Time;

public class Serviciu {
    private int id;
    private String nume_serviciu;
    private Double pret;
    private Time durata;

    public Serviciu(int id, String nume_serviciu, Double pret, Time durata) {
        this.id = id;
        this.nume_serviciu = nume_serviciu;
        this.pret = pret;
        this.durata = durata;
    }

    public int getId() {
        return id;
    }

    public String getNume_serviciu() {
        return nume_serviciu;
    }


    public Double getPret() {
        return pret;
    }

    public Time getDurata() {
        return durata;
    }

    @Override
    public String toString() {
        return "Serviciu{" +
                "id=" + id +
                ", nume_serviciu='" + nume_serviciu + '\'' +
                ", pret=" + pret +
                ", durata=" + durata +
                '}';
    }
}
