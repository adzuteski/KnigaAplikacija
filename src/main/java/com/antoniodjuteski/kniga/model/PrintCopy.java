package com.antoniodjuteski.kniga.model;

import com.antoniodjuteski.kniga.model.enums.TipNaKniga;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PrintCopy extends Kniga {
    @JsonProperty
    private int brojNaStrani;
    @JsonProperty
    private double tezina;

    public PrintCopy(String naslov, String ISBN, int godNaIzdavanje, Avtor avtor, int brojNaStrani, double tezina) {
        super(naslov, ISBN, godNaIzdavanje, avtor);
        this.brojNaStrani = brojNaStrani;
        this.tezina = tezina;
    }

    @Override
    public TipNaKniga getTipNaKniga() {
         return TipNaKniga.PRINT_COPY;
    }

    //geters and setters i toString()


    public int getBrojNaStrani() {
        return brojNaStrani;
    }

    public void setBrojNaStrani(int brojNaStrani) {
        this.brojNaStrani = brojNaStrani;
    }

    public double getTezina() {
        return tezina;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    @Override
    public String toString() {
        return "PrintCopy{" +
                super.toString() +
                "brojNaStrani=" + brojNaStrani +
                ", tezina=" + tezina +
                '}';
    }
}
