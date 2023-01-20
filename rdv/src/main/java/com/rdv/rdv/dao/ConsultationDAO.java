package com.rdv.rdv.dao;

import com.rdv.rdv.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationDAO extends JpaRepository<Consultation, Long> {
}
