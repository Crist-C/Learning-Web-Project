package com.sergioarboleda.rentcar.repositories;

import com.sergioarboleda.rentcar.models.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    // SELECT * FROM Reservation WHERE star_date >= ? AND end_date <= ? AND status = ?
    @Query(value = "SELECT * FROM Reservation WHERE star_date >= ? AND end_date <= ? AND status = ?", nativeQuery = true)
    List<Reservation> findReservationsByDatesAndState(String s_date, String e_date, String status);
}
