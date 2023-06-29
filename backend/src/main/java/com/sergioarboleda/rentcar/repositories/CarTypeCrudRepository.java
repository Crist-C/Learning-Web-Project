package com.sergioarboleda.rentcar.repositories;

import com.sergioarboleda.rentcar.models.CarType;
import org.springframework.data.repository.CrudRepository;

public interface CarTypeCrudRepository extends CrudRepository<CarType,Integer> {
}
