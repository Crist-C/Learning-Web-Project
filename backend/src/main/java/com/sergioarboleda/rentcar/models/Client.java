package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(length = 30, nullable = false, unique = true)
    private String phone;
    @Column(length = 6, nullable = false)
    private String countryPointer;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 50, nullable = false, unique = true)
    private String nickName;
    @Column(length = 50, nullable = false)
    private String password;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFk")
    @JsonIgnoreProperties("clientFK")
    private List<Reservation> reservationList;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "clientFk")
    @JsonIgnoreProperties("clientFk")
    private List<Pqr> pqrList;
}
