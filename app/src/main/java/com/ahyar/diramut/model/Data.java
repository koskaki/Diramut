package com.ahyar.diramut.model;

public class Data {
    private String id, namapenyakit, deskripsi, gejala, solusi;

    public Data(){

    }
    public Data(String id, String namapenyakit,String deskripsi, String gejala, String solusi){
        this.id = id;
        this.namapenyakit = namapenyakit;
        this.deskripsi = deskripsi;
        this.gejala = gejala;
        this.solusi = solusi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamapenyakit() {
        return namapenyakit;
    }

    public void setNamapenyakit(String namapenyakit) {
        this.namapenyakit = namapenyakit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }
}
