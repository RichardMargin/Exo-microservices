package com.rdv.rdv.controller;

import com.rdv.rdv.dto.MedecinRdvsDto;
import com.rdv.rdv.dto.PatientRdvsDto;
import com.rdv.rdv.dto.RdvDto;
import com.rdv.rdv.model.Rdv;
import com.rdv.rdv.service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rdvs")
public class RdvController {

    @Autowired
    private RdvService rdvService;

    @GetMapping("/")
    public ResponseEntity<List<RdvDto>> findAll() {
        List<RdvDto> rdvs = rdvService.findAll();
        if (rdvs != null && !rdvs.isEmpty()) {
            return new ResponseEntity<>(rdvs, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


    @GetMapping("/medecin-info/{id}")
    public ResponseEntity<MedecinRdvsDto> findAllRdvsByIdMedecin(@PathVariable Long id) {
        MedecinRdvsDto result  = rdvService.findAllRdvsByIdMedecin(id);

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/patient-info/{id}")
    public ResponseEntity<PatientRdvsDto> findAllRdvsByIdPatient(@PathVariable Long id) {
        PatientRdvsDto result  = rdvService.findAllRdvsByIdPatient(id);

        if (result != null) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/{id}")
    public ResponseEntity<RdvDto> findById(@PathVariable Long id) {
        Optional<RdvDto> rdv = rdvService.findById(id);
        if (rdv.isPresent()) {
            return new ResponseEntity<>(rdv.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/idPatient/{idPatient}/idMedecin/{idMedecin}")
    public ResponseEntity<Rdv> save(@RequestBody Rdv rdv, @PathVariable Long idPatient, @PathVariable Long idMedecin) {
        Rdv rd = rdvService.save(rdv, idPatient, idMedecin);
        if (rd != null) {
            return new ResponseEntity<>(rd, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/idPatient/{idPatient}/idMedecin/{idMedecin}")
    public ResponseEntity<Rdv> update(@RequestBody Rdv rdv, @PathVariable Long idPatient, @PathVariable Long idMedecin) {
        Rdv rd = rdvService.save(rdv, idPatient, idMedecin);
        if (rd != null) {
            return new ResponseEntity<>(rd, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rdv> deleteById(@PathVariable Long id) {
        rdvService.deleteById(id);
        Optional<RdvDto> rdv = rdvService.findById(id);
        if (!rdv.isPresent()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/")
    public ResponseEntity<Rdv> deleteAll() {
        rdvService.deleteAll();
        List<RdvDto> rdvs = rdvService.findAll();
        if (rdvs == null || rdvs.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
