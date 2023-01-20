package com.rdv.rdv.service;

import com.rdv.rdv.model.Rdv;

import java.util.List;
import java.util.Optional;

public interface RdvService {
    List<Rdv> findAll();

    Optional<Rdv> findById(Long id);

    Rdv save(Rdv rdv, Long idPatient, Long idMedecin);

    void deleteById(Long id);

    void deleteAll();
}
