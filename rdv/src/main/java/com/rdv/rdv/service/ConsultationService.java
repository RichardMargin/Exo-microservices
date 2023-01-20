package com.rdv.rdv.service;

import com.rdv.rdv.dto.MedecinDto;
import com.rdv.rdv.model.Consultation;

import java.util.List;
import java.util.Optional;

public interface ConsultationService {

    List<Consultation> findAll();
    Optional<Consultation> findById(Long id);

    Consultation save(Consultation consultation);

    void deleteById(Long id);

    void deleteAll();

}
