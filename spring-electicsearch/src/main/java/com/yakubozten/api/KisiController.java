package com.yakubozten.api;

import com.yakubozten.entity.Kisi;
import com.yakubozten.repository.KisiRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {
    private  final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi= new Kisi();
        kisi.setAd("yakub");
        kisi.setSoyad("Özten");
        kisi.setAdres("test");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("K000sa1");

        kisiRepository.save(kisi);
    }
@GetMapping("/{search}")
public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
    List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search, search);
    return ResponseEntity.ok(kisiler);
}


}
