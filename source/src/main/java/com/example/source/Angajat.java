package com.example.source;

public class Angajat {
    private String nume;

    private String prenume;
    private String functie;

    public Angajat(String nume, String prenume, String functie) {
        this.nume = nume;
        this.prenume = prenume;
        this.functie = functie;
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
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", functie='" + functie + '\'' +
                '}';
    }
}
