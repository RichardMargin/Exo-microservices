package com.rdv.rdv.dto;

import com.rdv.rdv.model.Rdv;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PatientRdvsDto {


    private Long id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String telephone;
    private List<Rdv> rdvList;
}
