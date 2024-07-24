package com.yakubozten.rc.api.model;

import java.util.List;


public class KisiDto {

    private  long id;

    private String adi;

    private String soyadi;

    private List<String> adresler;

    @Override
    public String toString() {
        return "KisiDto{" +
                "id=" + id +
                ", adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", adresler=" + adresler +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public List<String> getAdresler() {
        return adresler;
    }

    public void setAdresler(List<String> adresler) {
        this.adresler = adresler;
    }
}
