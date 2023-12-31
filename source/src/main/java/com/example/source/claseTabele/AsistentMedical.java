package com.example.source.claseTabele;

public class AsistentMedical {
    private Integer id;
    private String tip;
    private String grad;

    public AsistentMedical(Integer id, String tip, String grad) {
        this.id = id;
        this.tip = tip;
        this.grad = grad;
    }

    public Integer getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    public String getGrad() {
        return grad;
    }

    @Override
    public String toString() {
        return "AsistentMedical{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", grad='" + grad + '\'' +
                '}';
    }
}
