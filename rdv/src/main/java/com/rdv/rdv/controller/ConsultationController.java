package com.rdv.rdv.controller;

import com.rdv.rdv.model.Consultation;
import com.rdv.rdv.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/")
    public ResponseEntity<List<Consultation>> findAll() {
        List<Consultation> consultations = consultationService.findAll();
        if (consultations != null && !consultations.isEmpty()) {
            return new ResponseEntity<>(consultations, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> findById(@PathVariable Long id) {
        Optional<Consultation> consultation = consultationService.findById(id);
        if (consultation.isPresent()) {
            return new ResponseEntity<>(consultation.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    public ResponseEntity<Consultation> update(@RequestBody Consultation consultation) {
        Consultation consul = consultationService.save(consultation);
        if (consul != null) {
            return new ResponseEntity<>(consul, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Consultation> deleteById(@PathVariable Long id) {
        consultationService.deleteById(id);
        Optional<Consultation> consultation = consultationService.findById(id);
        if (!consultation.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/")
    public ResponseEntity<Consultation> deleteAll() {
        consultationService.deleteAll();
        List<Consultation> consultations = consultationService.findAll();
        if (consultations == null || consultations.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
