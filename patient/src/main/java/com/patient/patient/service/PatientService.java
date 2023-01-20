package com.patient.patient.service;

import com.patient.patient.dao.PatientDAO;
import com.patient.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDAO repo;


    public List<Patient> getAll() {
        return (List<Patient>) repo.findAll();
    }
}
