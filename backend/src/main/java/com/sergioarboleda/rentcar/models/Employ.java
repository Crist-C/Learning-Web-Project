package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="employees")
public class Employ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmploy;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(length = 30, nullable = false, unique = true)
    private String phone;
    @Column(length = 6, nullable = false)
    private String countryPointer;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "BOOLEAN DEFAULT false",nullable = false)
    private Boolean mangment;
    @Column(length = 50, nullable = false, unique = true)
    private String nickName;
    @Column(length = 50, nullable = false)
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "employFk")
    @JsonIgnoreProperties("employFk")
    private List<ReservationLogs> reservationLogsList;

}
