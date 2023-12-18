package com.example.source.claseTabele;

public class Angajat {
    private int id;
    private int id_utilizator;
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

    @Override
    public String toString() {
        return "Angajat{" +
                "id=" + id +
                ", id_utilizator=" + id_utilizator +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", functie='" + functie + '\'' +
                '}';
    }
}
