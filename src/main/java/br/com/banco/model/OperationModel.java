package br.com.banco.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "operation")
public class OperationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cod", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private Date initialDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private String name;

    private double valence;

    @Column(nullable = false)
    private double balance;



}
