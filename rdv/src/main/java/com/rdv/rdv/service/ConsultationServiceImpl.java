package com.rdv.rdv.service;

import com.rdv.rdv.dao.ConsultationDAO;
import com.rdv.rdv.model.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService{

    @Autowired
    private ConsultationDAO consultationRepository;

    @Override
    public List<Consultation> findAll() {
        return consultationRepository.findAll();
    }

    @Override
    public Optional<Consultation> findById(Long id) {
        return consultationRepository.findById(id);
    }

    @Override
    public Consultation save(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public void deleteById(Long id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        consultationRepository.deleteAll();
    }
}
