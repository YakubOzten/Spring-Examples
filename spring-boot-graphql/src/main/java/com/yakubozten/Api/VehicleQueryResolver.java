package com.yakubozten.Api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.yakubozten.Repo.VehicleRepository;
import com.yakubozten.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository vehicleRepository;
    public List<Vehicle> getVehicles(String type){
     return vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id){
  return vehicleRepository.findById(id);
    }
}
