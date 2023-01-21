package com.rdv.rdv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
