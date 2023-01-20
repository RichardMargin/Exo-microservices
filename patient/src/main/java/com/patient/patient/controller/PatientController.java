package com.patient.patient.controller;

import com.patient.patient.model.Patient;
import com.patient.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

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

}
