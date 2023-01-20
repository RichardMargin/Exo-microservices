package com.rdv.rdv.service;

import com.rdv.rdv.apiClient.MedecinApiClient;
import com.rdv.rdv.apiClient.PatientApiClient;
import com.rdv.rdv.dao.RdvDAO;
import com.rdv.rdv.dto.MedecinDto;
import com.rdv.rdv.dto.PatientDto;
import com.rdv.rdv.model.Consultation;
import com.rdv.rdv.model.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RdvServiceImpl implements RdvService{

    @Autowired
    private RdvDAO rdvRepository;

    @Autowired
    private ConsultationService consultationService;

    private MedecinApiClient medecinApiClient;

    private PatientApiClient patientApiClient;

    @Override
    public List<Rdv> findAll() {
        return rdvRepository.findAll();
    }

    @Override
    public Optional<Rdv> findById(Long id) {
        return rdvRepository.findById(id);
    }

    @Override
    public Rdv save(Rdv rdv, Long idPatient, Long idMedecin) {
        System.out.println("je suis là");
        PatientDto patient = patientApiClient.findById(idPatient);
        MedecinDto medecin = medecinApiClient.findById(idMedecin);
        if (medecin != null && patient != null) {
            rdv.setPatientId(idPatient);
            rdv.setPatientId(idMedecin);
        }
        if (rdv.getId()==null) {
            Consultation consultation = consultationService.save(new Consultation());
            rdv.setConsultation(consultation);
        }
        return rdvRepository.save(rdv);
    }

    @Override
    public void deleteById(Long id) {
        rdvRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        rdvRepository.deleteAll();
    }
}
