package com.example.source.claseTabele;

public class Medic {
    private Integer id;
    private String cod_parafa;
    private String titlu_stiintific;
    private String post_didactic;
    private Double venit_aditional;

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

    @Override
    public String toString() {
        return "Medic{" +
                "id=" + id +
                ", cod_parafa='" + cod_parafa + '\'' +
                ", titlu_stiintific='" + titlu_stiintific + '\'' +
                ", post_didactic='" + post_didactic + '\'' +
                ", venit_aditional=" + venit_aditional +
                '}';
    }
}
