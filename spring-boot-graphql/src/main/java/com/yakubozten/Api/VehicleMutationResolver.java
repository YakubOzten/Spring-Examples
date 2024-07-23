package com.yakubozten.Api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.yakubozten.Repo.VehicleRepository;
import com.yakubozten.dto.VehicleDto;
import com.yakubozten.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto){
       return vehicleRepository.save(dtoToEntity(vehicleDto));
    }
    private Vehicle dtoToEntity(VehicleDto vehicleDto){
         Vehicle vehicle=new Vehicle();
         vehicle.setBrandName(vehicleDto.getBrandName());
         vehicle.setModelCode(vehicleDto.getModelCode());
         vehicle.setLaunchDate(new Date());
         vehicle.setType(vehicleDto.getType());
         return vehicle;
    }
}
