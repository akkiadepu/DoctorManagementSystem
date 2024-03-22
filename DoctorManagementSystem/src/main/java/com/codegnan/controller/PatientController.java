package com.codegnan.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegnan.entity.Patient;

import com.codegnan.exection.invalidPatientIdExection;

import com.codegnan.services.PatientServices;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://13.50.109.26:3000/")
public class PatientController {
	
	PatientServices patientServices;

	public PatientController(PatientServices patientServices) {
		super();
		
		this.patientServices = patientServices;
	}
	

	@GetMapping
	public ResponseEntity<List<Patient>> findAll() {
		List<Patient> patients =patientServices.findAllPatients();
		ResponseEntity<List<Patient>> responseEntity = new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
		return responseEntity;		
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<Patient> findPatientById(@PathVariable("id") int id) throws invalidPatientIdExection  {
		Patient patient =patientServices.findPatientsById(id);
		ResponseEntity<Patient> responseEntity = new ResponseEntity<Patient>(patient, HttpStatus.FOUND);
		return responseEntity;
		
	}
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
		System.out.println(" patient "+patient);
		Patient patientsaved = patientServices.savePatients(patient);
		ResponseEntity<Patient> responseEntity = new ResponseEntity<Patient>(patientsaved, HttpStatus.ACCEPTED);
//		System.out.println("data of "+patient);
		return responseEntity;

	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Patient> editPatient(@PathVariable("id") int id ,@RequestBody Patient patient) throws invalidPatientIdExection {
		if(id != patient.getid()) {
			throw new invalidPatientIdExection("id "+id+" is not matching with patient.id "+patient.getid());
		}
		Patient editedPatient = patientServices.editPatients(patient);
		ResponseEntity<Patient> responseEntity = new ResponseEntity<Patient>(editedPatient, HttpStatus.ACCEPTED);
		return responseEntity;
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable int id) throws invalidPatientIdExection  {
		Patient patient = patientServices.deletePatientsByid(id);
		ResponseEntity<Patient> responseEntity = new ResponseEntity<Patient>(patient, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	

	
	
	
	

}
