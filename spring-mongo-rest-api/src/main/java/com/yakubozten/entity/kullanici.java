package com.yakubozten.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
@Document
public class kullanici {
    @Id
    private  String id;
    private  String adi;

    private  String Soyadi;
    private HashMap Ozellikleri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return Soyadi;
    }

    public void setSoyadi(String soyadi) {
        Soyadi = soyadi;
    }

    public HashMap getOzellikleri() {
        return Ozellikleri;
    }

    public void setOzellikleri(HashMap ozellikleri) {
        Ozellikleri = ozellikleri;
    }
}
