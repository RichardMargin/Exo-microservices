package com.patient.patient.dao;

import com.patient.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource
public interface PatientDAO extends JpaRepository<Patient, Long> {
}
