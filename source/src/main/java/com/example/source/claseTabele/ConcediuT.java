package com.example.source.claseTabele;

import java.sql.Date;

public class ConcediuT {
    private int id;
    private int id_utilzator;
    private Date data_inceput;
    private Date data_sfarsit;

    public ConcediuT(int id, int id_utilzator, Date data_inceput, Date data_sfarsit) {
        this.id = id;
        this.id_utilzator = id_utilzator;
        this.data_inceput = data_inceput;
        this.data_sfarsit = data_sfarsit;
    }

    public Date getData_inceput() {
        return data_inceput;
    }

    public Date getData_sfarsit() {
        return data_sfarsit;
    }
}
