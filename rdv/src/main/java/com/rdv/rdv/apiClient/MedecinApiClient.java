package com.rdv.rdv.apiClient;

import com.rdv.rdv.dto.MedecinDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "MEDECIN", url = "http://localhost:9091")
public interface MedecinApiClient {

    @GetMapping(value = "/medecins/{id}")
    MedecinDto findById(@PathVariable("id") Long id);
}
