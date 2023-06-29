package com.sergioarboleda.rentcar.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="pqrs")
public class Pqr implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPqr;
    @Column(length = 50, nullable = false)
    private String type;
    @Column(nullable = false)
    private Integer score;
    @Column(length = 1000)
    private String message;
    @Column(nullable = false)
    private String fullName;
    @Column(length = 30, nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    private Integer reservationId;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    @JsonIgnoreProperties("pqrList")
    private Client clientFk;
}
