package com.example.source.claseTabele;

public class Angajat {
    private int id;
    private int id_utilizator;
    private int id_policlinica;
    private String nume;
    private String prenume;
    private String functie;
    private int salariu_negociat;
    private int numar_ore;

    public Angajat(int id, int id_utilizator, String nume, String prenume, String functie) {
        this.id = id;
        this.id_utilizator = id_utilizator;
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
    }

    public Angajat(int id, int id_utilizator, int id_policlinica, String nume, String prenume, String functie, int salariu_negociat, int numar_ore) {
        this.id = id;
        this.id_utilizator = id_utilizator;
        this.id_policlinica = id_policlinica;
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
        this.salariu_negociat = salariu_negociat;
        this.numar_ore = numar_ore;
    }

    public int getId() {
        return id;
    }

    public int getId_utilizator() {
        return id_utilizator;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getFunctie() {
        return functie;
    }

    public int getId_policlinica() {
        return id_policlinica;
    }

    public int getSalariu_negociat() {
        return salariu_negociat;
    }

    public int getNumar_ore() {
        return numar_ore;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "id=" + id +
                ", id_utilizator=" + id_utilizator +
                ", id_policlinica=" + id_policlinica +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", functie='" + functie + '\'' +
                ", salariu_negociat=" + salariu_negociat +
                ", numar_ore=" + numar_ore +
                '}';
    }
}
