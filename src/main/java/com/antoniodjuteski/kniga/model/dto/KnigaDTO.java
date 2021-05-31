package com.antoniodjuteski.kniga.model.dto;

import com.antoniodjuteski.kniga.model.Avtor;
import com.antoniodjuteski.kniga.model.enums.Format;
import com.antoniodjuteski.kniga.model.enums.TipNaKniga;

public class KnigaDTO {

        private String naslov;
        private String ISBN;
        private int godNaIzdavanje;
        private Avtor avtor;
        private TipNaKniga tipNaKniga;
        private Format format;
        private double goleminaVoMB;
        private int brojNaStrani;
        private double tezina;

        public KnigaDTO(String naslov, String ISBN, int godNaIzdavanje, Avtor avtor, TipNaKniga tipNaKniga,
                        Format format, double goleminaVoMB, int brojNaStrani, double tezina) {
                this.naslov = naslov;
                this.ISBN = ISBN;
                this.godNaIzdavanje = godNaIzdavanje;
                this.avtor = avtor;
                this.tipNaKniga = tipNaKniga;
                this.format = format;
                this.goleminaVoMB = goleminaVoMB;
                this.brojNaStrani = brojNaStrani;
                this.tezina = tezina;
        }

        //geteri, seteri i toString()


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

        public TipNaKniga getTipNaKniga() {
                return tipNaKniga;
        }

        public void setTipNaKniga(TipNaKniga tipNaKniga) {
                this.tipNaKniga = tipNaKniga;
        }

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
                return "KnigaDTO{" +
                        "naslov='" + naslov + '\'' +
                        ", ISBN='" + ISBN + '\'' +
                        ", godNaIzdavanje=" + godNaIzdavanje +
                        ", avtor=" + avtor +
                        ", tipNaKniga=" + tipNaKniga +
                        ", format=" + format +
                        ", goleminaVoMB=" + goleminaVoMB +
                        ", brojNaStrani=" + brojNaStrani +
                        ", tezina=" + tezina +
                        '}';
        }
}

