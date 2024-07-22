package com.yakubozten.controller;

import com.yakubozten.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet API Dökümantasyonum")
public class PetController {

   private List<Pet> petList=new ArrayList<>();

   @PostConstruct
   public  void  init(){
       petList.add(new Pet(1,"test pet",new Date()));
   }
    @PostMapping
    @ApiOperation(value = "Yeni Pet Ekleme Metodu",notes = "Bu Metodu dikkatli kullan")
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "hayvan") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }
    @GetMapping
    @ApiOperation(value = "Pet listesi Metodu",notes = "Bu Metod Sayfalama yapar.")
    public ResponseEntity<List<Pet>> TumunuListele(){

        return ResponseEntity.ok(petList);
    }
}

