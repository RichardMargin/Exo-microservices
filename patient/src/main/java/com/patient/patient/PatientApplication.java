package com.patient.patient;

import com.patient.patient.dao.PatientDAO;
import com.patient.patient.model.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientDAO patientDAO) {
		return args -> {
			Stream.of("ent1", "ent2", "ent3").forEach(cn -> {
				patientDAO.save(new Patient());
			});
			patientDAO.findAll().forEach(System.out::println);
		};
	}
}