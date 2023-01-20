package com.rdv.rdv.service;

import com.rdv.rdv.apiClient.MedecinApiClient;
import com.rdv.rdv.apiClient.PatientApiClient;
import com.rdv.rdv.dao.RdvDAO;
import com.rdv.rdv.dto.MedecinDto;
import com.rdv.rdv.dto.MedecinRdvsDto;
import com.rdv.rdv.dto.PatientDto;
import com.rdv.rdv.model.Consultation;
import com.rdv.rdv.model.Rdv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RdvServiceImpl implements RdvService{

    @Autowired
    private RdvDAO rdvRepository;

    @Autowired
    private ConsultationService consultationService;

    private final MedecinApiClient medecinApiClient;

    private final PatientApiClient patientApiClient;

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
        PatientDto patient = patientApiClient.findById(idPatient);
        MedecinDto medecin = medecinApiClient.findById(idMedecin);
        if (medecin != null && patient != null) {
            rdv.setPatientId(idPatient);
            rdv.setMedecinId(idMedecin);
        }
        if (rdv.getId()==null) {
            Consultation consultation = consultationService.save(new Consultation());
            rdv.setConsultation(consultation);
        }
        return rdvRepository.save(rdv);
    }

    @Override
    public MedecinRdvsDto findAllRdvsByIdMedecin(Long idMedecin) {
        MedecinDto medecin = medecinApiClient.findById(idMedecin);


        MedecinRdvsDto result = new MedecinRdvsDto();
        if(medecin != null){
            List<Rdv> allRdvs = findAll();
            var rdvList = allRdvs.stream().filter(rdv -> rdv.getMedecinId() == idMedecin).collect(Collectors.toList());
            result.setId(medecin.getId());
            result.setNom(medecin.getNom());
            result.setPrenom(medecin.getPrenom());
            result.setSpecialite(medecin.getSpecialite());
            result.setRdvList(rdvList);

        }
        return result;
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
