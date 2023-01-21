package com.medecin.medecin.dao;

import com.medecin.medecin.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface MedecinDAO extends JpaRepository<Medecin, Long> {

}