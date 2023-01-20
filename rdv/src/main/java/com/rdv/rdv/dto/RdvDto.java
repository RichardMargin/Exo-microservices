package com.rdv.rdv.dto;

import com.rdv.rdv.model.Consultation;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
public class RdvDto {
    @Id
    private Long id;

    private Date dateRdv;

    private PatientDto patient;

    private MedecinDto medecin;

    private Consultation consultation;
}
