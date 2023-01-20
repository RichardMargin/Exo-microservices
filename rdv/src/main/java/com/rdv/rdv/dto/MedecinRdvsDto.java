package com.rdv.rdv.dto;

import com.rdv.rdv.model.Rdv;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class MedecinRdvsDto {


    private Long id;

    private String nom;

    private String prenom;

    private String specialite;

    private List<Rdv> rdvList;
}
