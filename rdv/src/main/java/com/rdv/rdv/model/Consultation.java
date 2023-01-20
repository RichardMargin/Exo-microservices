package com.rdv.rdv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostique;
    private String traitement;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL)
    @JsonIgnore
    private Rdv rdv;
}
