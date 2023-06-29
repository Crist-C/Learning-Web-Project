package com.sergioarboleda.rentcar.repositories;

import com.sergioarboleda.rentcar.models.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarCrudRepository extends CrudRepository<Car,Integer> {

    Optional<Car> findByPlate(String plate);

    List<Car> findByYear(Integer year);
}
