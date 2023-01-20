package com.rdv.rdv.service;

import com.rdv.rdv.dto.MedecinRdvsDto;
import com.rdv.rdv.dto.PatientRdvsDto;
import com.rdv.rdv.dto.RdvDto;
import com.rdv.rdv.model.Rdv;

import java.util.List;
import java.util.Optional;

public interface RdvService {
    List<RdvDto>findAll();

    Optional<RdvDto> findById(Long id);

    Rdv save(Rdv rdv, Long idPatient, Long idMedecin);

    void deleteById(Long id);

    void deleteAll();

    MedecinRdvsDto findAllRdvsByIdMedecin(Long idMedecin);

    PatientRdvsDto findAllRdvsByIdPatient(Long idPatient);


}
