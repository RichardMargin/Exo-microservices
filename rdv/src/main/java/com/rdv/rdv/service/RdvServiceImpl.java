package com.rdv.rdv.service;

import com.rdv.rdv.apiClient.MedecinApiClient;
import com.rdv.rdv.apiClient.PatientApiClient;
import com.rdv.rdv.dao.RdvDAO;
import com.rdv.rdv.dto.*;
import com.rdv.rdv.model.Consultation;
import com.rdv.rdv.model.Rdv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Array;
import java.util.ArrayList;
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
    public List<RdvDto> findAll() {

        List<Rdv> rdvList = rdvRepository.findAll();
        List<RdvDto> result = new ArrayList<>();

        rdvList.stream().forEach(rdv -> {
            var medecin = medecinApiClient.findById(rdv.getMedecinId());
            var patient = patientApiClient.findById(rdv.getPatientId());
            var rdvDto = new RdvDto();

            medecin.setId(rdv.getMedecinId());
            patient.setId(rdv.getPatientId());
            rdvDto.setId(rdv.getId());
            rdvDto.setDateRdv(rdv.getDateRdv());
            rdvDto.setConsultation(rdv.getConsultation());
            rdvDto.setMedecin(medecin);
            rdvDto.setPatient(patient);
            result.add(rdvDto);
        });

        return result;

    }


    private List<Rdv> findAllRdv() {
        return rdvRepository.findAll();

    }

    @Override
    public Optional<RdvDto> findById(Long id) {

        Optional<Rdv> rdv = rdvRepository.findById(id);
        var result = new RdvDto();

        if(rdv.isPresent()){
            var medecin = medecinApiClient.findById(rdv.get().getMedecinId());
            var patient = patientApiClient.findById(rdv.get().getPatientId());

            medecin.setId(rdv.get().getMedecinId());
            patient.setId(rdv.get().getPatientId());
            result.setId(id);
            result.setDateRdv(rdv.get().getDateRdv());
            result.setConsultation(rdv.get().getConsultation());
            result.setMedecin(medecin);
            result.setPatient(patient);
        }

        return Optional.of(result);
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
            List<Rdv> allRdvs = findAllRdv();
            var rdvList = allRdvs.stream().filter(rdv -> rdv.getMedecinId() == idMedecin).collect(Collectors.toList());
            result.setId(idMedecin);
            result.setNom(medecin.getNom());
            result.setPrenom(medecin.getPrenom());
            result.setSpecialite(medecin.getSpecialite());
            result.setRdvList(rdvList);

        }
        return result;
    }

    @Override
    public PatientRdvsDto findAllRdvsByIdPatient(Long idPatient) {
        PatientDto patient = patientApiClient.findById(idPatient);


        PatientRdvsDto result = new PatientRdvsDto();
        if(patient != null){
            List<Rdv> allRdvs = findAllRdv();
            var rdvList = allRdvs.stream().filter(rdv -> rdv.getPatientId() == idPatient).collect(Collectors.toList());
            result.setId(idPatient);
            result.setNom(patient.getNom());
            result.setPrenom(patient.getPrenom());
            result.setTelephone(patient.getTelephone());
            result.setDateDeNaissance(patient.getDateDeNaissance());
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
