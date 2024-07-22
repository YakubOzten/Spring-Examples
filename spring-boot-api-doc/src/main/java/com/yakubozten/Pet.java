package com.yakubozten;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;



@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Benim Pet Nesnem",description = "Benim Pet")
public class Pet {
    @ApiModelProperty(value = "Pet Nesnesinin tekil Id Alanı")
    private int id;
    @ApiModelProperty(value = "Pet Nesnesinin Adı Alanı")
    private String name;
    @ApiModelProperty(value = "Pet Nesnesinin Tarih Alanı")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
