package com.example.source.claseTabele;

public class Specialitati {
    private Integer id;
    private String nume_specialitate;
    private String grad;

    public Specialitati(Integer id, String nume_specialitate, String grad) {
        this.id = id;
        this.nume_specialitate = nume_specialitate;
        this.grad = grad;
    }

    public Integer getId() {
        return id;
    }

    public String getNume_specialitate() {
        return nume_specialitate;
    }

    public String getGrad() {
        return grad;
    }

    @Override
    public String toString() {
        return "Specialitati{" +
                "id=" + id +
                ", nume_specialitate='" + nume_specialitate + '\'' +
                ", grad='" + grad + '\'' +
                '}';
    }
}
