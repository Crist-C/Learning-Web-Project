package com.sergioarboleda.rentcar.repositories;

import com.sergioarboleda.rentcar.models.ReservationLogs;
import org.springframework.data.repository.CrudRepository;

public interface ReservationLogsCrudRepository extends CrudRepository<ReservationLogs,Integer> {
}
