package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="car_types")
public class CarType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarType;
    @Column(length = 50, nullable = false)
    private String gama;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "carTypeFk")
    @JsonIgnoreProperties("carTypeFk")
    private List<Car> cars;
}
