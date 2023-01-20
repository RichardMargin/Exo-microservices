package com.rdv.rdv.apiClient;

import com.rdv.rdv.dto.MedecinDto;
import com.rdv.rdv.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PATIENT", url = "http://localhost:9092")
public interface PatientApiClient {

    @GetMapping(value = "/patients/{id}")
    PatientDto findById(@PathVariable("id") Long id);
}
