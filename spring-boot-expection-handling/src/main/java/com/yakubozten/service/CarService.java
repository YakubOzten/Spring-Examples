package com.yakubozten.service;

import com.yakubozten.dto.Car;
import com.yakubozten.exception.EntityNotfoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

 private static List<Car> carList= new ArrayList<>();

    @PostConstruct
    public  void init(){
       carList.add(new Car("Car A","brand-1"));
        carList.add(new Car("Car B","brand-2"));
        carList.add(new Car("Car C","brand-3"));

    }
    public Car getCar(String name){
        if (name.startsWith("1")){
            throw  new IllegalArgumentException();
        }
      return carList.stream().filter(item -> item.getName().equals(name)).findFirst()
                .orElseThrow(()-> new EntityNotfoundException(name));

    }
}
