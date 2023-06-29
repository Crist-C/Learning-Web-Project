package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="reservations")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column(length = 50, nullable = false)
    private String status;
    @Column(length = 50, nullable = false)
    private String startDate;
    @Column(length = 50, nullable = false)
    private String endDate;


    @ManyToOne
    @JoinColumn(name = "idCar", nullable = false)
    @JsonIgnoreProperties("reservationList")
    private Car carFk;


    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    @JsonIgnoreProperties("reservationList")
    private Client clientFk;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "reservationFk")
    @JsonIgnoreProperties("reservationFk")
    private List<ReservationLogs> reservationLogsList;

}
