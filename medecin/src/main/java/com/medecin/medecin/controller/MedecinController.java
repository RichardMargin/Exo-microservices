package com.medecin.medecin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class MedecinController {

    //@Autowired
    private RestTemplate restTemplate = new RestTemplate();

    @Value("${server.port}")
    private int port;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${global}")
    private String global;


    @GetMapping(path = "/myConfig")
    public Map<String, Object> myConfig() {
        Map<String, Object> params = new HashMap<>();
        params.put("server.port", port);
        params.put("spring.datasource.url", url);
        params.put("global", global);

        return params;
    }






    @GetMapping("/patients")
    public List<Object> getPatients() {
        Object[] patients = restTemplate.getForObject("http://localhost:9092/patients", Object[].class);
        return Arrays.asList(patients);
    }


    @GetMapping("/onePatient")
    public Object getOnePatient() {
        Object patient = restTemplate.getForObject("http://localhost:9092/patients/4", Object.class);
        return patient;
    }
}
