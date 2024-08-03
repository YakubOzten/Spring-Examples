package com.yakubozten.repo;

import com.yakubozten.entity.Car;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @QueryHints({@QueryHint(name="org.hibernate.cacheable",value="true")})
    List<Car> findAll();
}
