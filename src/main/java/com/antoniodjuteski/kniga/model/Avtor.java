package com.antoniodjuteski.kniga.model;

public class Avtor {
    private String ime;
    private String prezime;
    private int rodenVoGodina;

    public Avtor(String ime, String prezime, int rodenVoGodina) {
        this.ime = ime;
        this.prezime = prezime;
        this.rodenVoGodina = rodenVoGodina;
    }

    //geteri, seteri toSTring()

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getRodenVoGodina() {
        return rodenVoGodina;
    }

    public void setRodenVoGodina(int rodenVoGodina) {
        this.rodenVoGodina = rodenVoGodina;
    }

    @Override
    public String toString() {
        return "Avtor{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", rodenVoGodina=" + rodenVoGodina +
                '}';
    }
}
