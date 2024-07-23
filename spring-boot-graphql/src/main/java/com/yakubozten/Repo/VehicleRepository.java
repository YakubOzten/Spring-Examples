package com.yakubozten.Repo;

import com.yakubozten.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> getByTypeLike(String type);
}
