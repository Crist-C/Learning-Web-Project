package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.core.annotation.Order;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;
    @Column(length = 100, nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(length = 20, nullable = false)
    private String plate;
    @Column(length = 50, nullable = false)
    private String color;
    @Column(length = 5000)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name="idCarType", nullable = false)
    @JsonIgnoreProperties("cars")
    private CarType carTypeFk;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "carFk")
    @JsonIgnoreProperties("carFk")
    private List<Reservation> reservationList;
}
