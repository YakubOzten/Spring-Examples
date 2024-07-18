package com.yakubozten.Controller;

import com.yakubozten.entity.kullanici;
import com.yakubozten.repository.KullaniciRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kullanici")
public class KullanıcıApi {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init(){
        kullanici Kullanici= new kullanici();
        Kullanici.setAdi("yakub");
        Kullanici.setSoyadi("Özten");

        kullaniciRepository.save(Kullanici);
    }
    public ResponseEntity<kullanici> ekle(@RequestBody kullanici Kullanici){
        return ResponseEntity.ok(kullaniciRepository.save(Kullanici));
    }
    public ResponseEntity<List<kullanici>> TumunuListele(){
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }
}
