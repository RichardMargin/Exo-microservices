package com.rdv.rdv.dto;

import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {

    @Id
    private Long id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String telephone;

}
