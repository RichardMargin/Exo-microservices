package com.rdv.rdv.dao;

import com.rdv.rdv.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RdvDAO extends JpaRepository<Rdv, Long> {

}
