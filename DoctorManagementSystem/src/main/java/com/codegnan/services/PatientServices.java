package com.codegnan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.exection.invalidPatientIdExection;
import com.codegnan.repo.PatientRepo;

@Service
public class PatientServices {

	PatientRepo patientRepo;

	public PatientServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public PatientServices(PatientRepo patientRepo) {
		super();
		this.patientRepo = patientRepo;
	}

	public List<Patient> findAllPatients() {
		return patientRepo.findAll();
	}

	public Patient findPatientsById(int id) throws invalidPatientIdExection {
		Optional<Patient> patient = patientRepo.findById(id);
		if (!patient.isPresent()) {
			throw new invalidPatientIdExection("Student id is not valid : " + id);
		}
		return patient.get();
	}

	
	public Patient savePatients(Patient patient) {
		return patientRepo.save(patient);
	}

	public Patient editPatients(Patient patient) throws invalidPatientIdExection {
		findPatientsById(patient.getid());
		patientRepo.save(patient);
		return patient;
	}

	public Patient deletePatientsByid(int id) throws invalidPatientIdExection {
		Patient patient = findPatientsById(id);
		patientRepo.deleteById(id);
		return patient;

	}

	public List<Patient> findPatientsByDoctor(Doctor doctor) {
		return patientRepo.findAllByDoctor(doctor);
	}

}
