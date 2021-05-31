package com.antoniodjuteski.kniga.model;

import com.antoniodjuteski.kniga.model.enums.TipNaKniga;



public abstract class Kniga {
    private String naslov;
    private String ISBN;
    private int godNaIzdavanje;
    private Avtor avtor;

    public Kniga(String naslov, String ISBN, int godNaIzdavanje, Avtor avtor) {
        this.naslov = naslov;
        this.ISBN = ISBN;
        this.godNaIzdavanje = godNaIzdavanje;
        this.avtor = avtor; }

    public abstract TipNaKniga getTipNaKniga();

    //geteri, seteri toString()

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getGodNaIzdavanje() {
        return godNaIzdavanje;
    }

    public void setGodNaIzdavanje(int godNaIzdavanje) {
        this.godNaIzdavanje = godNaIzdavanje;
    }

    public Avtor getAvtor() {
        return avtor;
    }

    public void setAvtor(Avtor avtor) {
        this.avtor = avtor;
    }

    @Override
    public String toString() {
        return "Kniga{" +
                "naslov='" + naslov + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", godNaIzdavanje=" + godNaIzdavanje +
                ", avtor=" + avtor +
                '}';
    }
}
