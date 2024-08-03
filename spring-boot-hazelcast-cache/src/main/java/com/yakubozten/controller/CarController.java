package com.yakubozten.controller;

import com.yakubozten.entity.Car;
import com.yakubozten.repo.CarRepository;
import jakarta.servlet.http.PushBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CarController {

    private  final CarRepository carRepository;

    @GetMapping("/{id}")
    public Car getCar(@PathVariable long id){return carRepository.getOne(id); }

    @GetMapping()
    public List<Car> getCars(){return carRepository.findAll();}

    @PostMapping
    public Car save(@RequestBody Car car){ return carRepository.save(car);}

}
