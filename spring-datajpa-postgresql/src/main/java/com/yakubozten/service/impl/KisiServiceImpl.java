package com.yakubozten.service.impl;

import com.yakubozten.dto.KisiDto;
import com.yakubozten.entity.Adres;
import com.yakubozten.entity.Kisi;
import com.yakubozten.repo.AdresRepository;
import com.yakubozten.repo.KisiRepository;
import com.yakubozten.service.KisiService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {

    private  final KisiRepository kisiRepository;
    private  final AdresRepository adresRepository;

    @Override
    @Transactional
    public KisiDto save(KisiDto  kisiDto) {
       // Assert.isNull(kisiDto.getAdi(), "Adi alanı zorunludur!");
        Kisi kisi= new Kisi();
        //kisi.setId(kisiDto.getId());
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
      final Kisi kisiDb= kisiRepository.save(kisi);
        List<Adres> liste=new ArrayList<>();
        kisiDto.getAdresler().forEach(item -> {
           Adres adres=new Adres();
           adres.setAdres(String.valueOf(item));
           adres.setAdresTip(Adres.AdresTip.DIGER);
           adres.setAktif(true);
           adres.setKisi(kisiDb);
           liste.add(adres);

       });
       adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }


    @Override
    public void delete(long id) {

    }

    @Override

    public List<KisiDto> getAll() {
       List<Kisi> kisiler= kisiRepository.findAll();
       List<KisiDto>kisiDtos=new ArrayList<>();
        kisiler.forEach(it->{
            KisiDto kisiDto=new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(it.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}
