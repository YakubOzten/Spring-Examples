package com.yakubozten.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class MesajApi {
    @GetMapping
    public  String messajVer(){
         return "Docker Image inin icerisinden Merhaba ";
    }
}
