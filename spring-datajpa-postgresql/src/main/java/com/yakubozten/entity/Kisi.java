package com.yakubozten.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator ="seq_kisi",strategy = GenerationType.SEQUENCE)
    private  long id;
    @Column(name = "adi")
    private String adi;
    @Column(name = "soyadi")
    private String soyadi;


    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
   private List<Adres> adresleri;


}
