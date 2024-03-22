package com.codegnan;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codegnan.controller.PatientController;

@SpringBootApplication
@CrossOrigin(origins = "0.0.0.0")
public class DoctorManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorManagementSystemApplication.class, args);
		
		
		
	}

}
