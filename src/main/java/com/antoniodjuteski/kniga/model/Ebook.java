package com.antoniodjuteski.kniga.model;

import com.antoniodjuteski.kniga.model.enums.Format;
import com.antoniodjuteski.kniga.model.enums.TipNaKniga;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ebook extends Kniga{
     @JsonProperty
     private Format format;
     @JsonProperty
     private double goleminaVoMB;

    public Ebook(String naslov, String ISBN, int godNaIzdavanje, Avtor avtor, Format format, double goleminaVoMB) {
        super(naslov, ISBN, godNaIzdavanje, avtor);
        this.format = format;
        this.goleminaVoMB = goleminaVoMB;
    }

    @Override
     public TipNaKniga getTipNaKniga() {
            return TipNaKniga.E_BOOK;
        }

    //geteri, seteri toString()

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public double getGoleminaVoMB() {
        return goleminaVoMB;
    }

    public void setGoleminaVoMB(double goleminaVoMB) {
        this.goleminaVoMB = goleminaVoMB;
    }

    @Override
    public String toString() {
        return "Ebook{" +
                super.toString() +
                "format=" + format +
                ", goleminaVoMB=" + goleminaVoMB +
                '}';
    }
}

