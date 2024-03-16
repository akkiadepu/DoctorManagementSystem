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

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.exection.invalidDoctorIdExection;

import com.codegnan.services.DoctorServices;
import com.codegnan.services.PatientServices;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:3000/")
public class DoctorController {
	
	DoctorServices doctorServices;
	PatientServices patientServices;
	
	public DoctorController(DoctorServices doctorServices, PatientServices patientServices) {
		super();
		this.doctorServices = doctorServices;
		this.patientServices = patientServices;
	}
	


	@GetMapping
	public ResponseEntity<List<Doctor>> findAllDoctor() {
		List<Doctor> doctors =doctorServices.findAllDoctors();
		ResponseEntity<List<Doctor>> responseEntity = new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
		return responseEntity;
		
	}
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> findDoctortById(@PathVariable int id) throws invalidDoctorIdExection {
		Doctor doctor = doctorServices.findDoctorsbyId(id);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(doctor, HttpStatus.FOUND);
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
		Doctor doctorsaved = doctorServices.saveDoctors(doctor);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(doctorsaved, HttpStatus.ACCEPTED);
		return responseEntity;
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> editDoctor(@PathVariable("id") int id ,@RequestBody Doctor doctor) throws  invalidDoctorIdExection {
		Doctor doctorsaved = doctorServices.editDoctors(doctor);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(doctorsaved, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Doctor>  deleteDoctor(@PathVariable("id") int id) throws invalidDoctorIdExection {
		Doctor doctor = doctorServices.deleteDoctorsByid(id);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(doctor, HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	
	
	@GetMapping("/{id}/patients")
	public ResponseEntity<List<Patient>> getPatientsByDoctor(@PathVariable int id) throws invalidDoctorIdExection  {
		Doctor doctor = doctorServices.findDoctorsbyId(id);
		List<Patient> patients = patientServices.findPatientsByDoctor(doctor);
		ResponseEntity<List<Patient>> responseEntity = new ResponseEntity<>(patients, HttpStatus.FOUND);
		return responseEntity;
	}
	
	
	

}
