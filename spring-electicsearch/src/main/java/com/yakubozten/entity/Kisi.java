package com.yakubozten.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "kisiler")
@Getter
@Setter
@NoArgsConstructor
public class Kisi {

    @Id
    private  String id;
    @Field(name = "ad",type = FieldType.Text)
    private String ad;
    @Field(name = "soyad",type = FieldType.Text)
    private  String soyad;
    @Field(name = "adres",type = FieldType.Text)
    private  String adres;
    @Field(name = "dogum_Tarihi",type = FieldType.Date)
    private Date dogumTarihi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public Kisi(String id, String ad, String soyad, String adres, Date dogumTarihi) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
        this.dogumTarihi = dogumTarihi;
    }


}
