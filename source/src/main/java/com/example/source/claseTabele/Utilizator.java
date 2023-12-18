package com.example.source.claseTabele;
public class Utilizator {
    private Integer id;
    private String departament;
    private String adresa;
    private String cnp;
    private String nume;
    private String prenume;
    private String telefon;
    private String email;
    private String iban;
    private String data_angajarii;
    private String rol;

    private Medic medic;
    private AsistentMedical asistentMedical;
    public Utilizator(Integer id, String departament, String adresa, String cnp, String nume, String prenume, String telefon, String email, String iban, String data_angajarii, String rol) {
        this.id = id;
        this.departament = departament;
        this.adresa = adresa;
        this.cnp = cnp;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.email = email;
        this.iban = iban;
        this.data_angajarii = data_angajarii;
        this.rol = rol;
        this.medic = null;
        this.asistentMedical = null;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public void setAsistentMedical(AsistentMedical asistentMedical) {
        this.asistentMedical = asistentMedical;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartament() {
        return departament;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getCnp() {
        return cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public String getIban() {
        return iban;
    }

    public String getData_angajarii() {
        return data_angajarii;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", departament='" + departament + '\'' +
                ", adresa='" + adresa + '\'' +
                ", cnp='" + cnp + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", iban='" + iban + '\'' +
                ", data_angajarii='" + data_angajarii + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
