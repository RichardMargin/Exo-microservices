package com.rdv.rdv.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class MedecinDto {

    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String specialite;

}
