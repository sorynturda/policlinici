package com.example.source.claseTabele;

public class Policlinica implements Cloneable{
    private int id;
    private int id_program_functionare;
    private String adresa;
    private String denumire;

    public Policlinica(int id, int id_program_functionare, String adresa, String denumire) {
        this.id = id;
        this.id_program_functionare = id_program_functionare;
        this.adresa = adresa;
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public int getId_program_functionare() {
        return id_program_functionare;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setId_program_functionare(int id_program_functionare) {
        this.id_program_functionare = id_program_functionare;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Override
    public String toString() {
        return "Policlinica{" +
                "id=" + id +
                ", id_program_functionare=" + id_program_functionare +
                ", adresa='" + adresa + '\'' +
                ", denumire='" + denumire + '\'' +
                '}';
    }

    @Override
    public Policlinica clone() {
        try {
            Policlinica clone = (Policlinica) super.clone();
            clone.setId(id);
            clone.setId_program_functionare(id_program_functionare);
            clone.setAdresa(adresa);
            clone.setDenumire(denumire);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
