package com.rdv.rdv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Rdv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateRdv;
    private Long patientId;
    private Long medecinId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consultation_id",referencedColumnName = "id")
    private Consultation consultation;

}
