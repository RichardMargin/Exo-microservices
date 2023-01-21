package com.patient.patient.dao;

import com.patient.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface PatientDAO extends JpaRepository<Patient, Long> {

}
