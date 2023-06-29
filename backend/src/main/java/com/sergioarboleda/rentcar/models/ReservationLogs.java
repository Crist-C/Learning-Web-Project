package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

import java.io.Serializable;

@Entity
@Table(name="reservation_logs")
public class ReservationLogs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLog;
    @Column(length = 50, nullable = false)
    private String stateBefore;
    @Column(length = 50, nullable = false)
    private String stareAfter;
    @Column(length = 50, nullable = false)
    private String date;

    @ManyToOne
    @JoinColumn(name = "idReservation", nullable = false)
    @JsonIgnoreProperties("reservationLogsList")
    private Reservation reservationFk;

    @ManyToOne
    @JoinColumn(name = "idEmploy", nullable = false)
    @JsonIgnoreProperties("reservationLogsList")
    private Employ employFk;

}
