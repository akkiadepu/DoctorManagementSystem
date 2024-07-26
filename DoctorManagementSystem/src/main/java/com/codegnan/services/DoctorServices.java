package com.codegnan.services;

import java.util.List;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;
import com.codegnan.exection.invalidDoctorIdExection;
import com.codegnan.repo.DoctorRepo;

@Service
public class DoctorServices {

	DoctorRepo doctorRepo;
	Logger log = Logger.getLogger(DoctorServices.class);
	
	public DoctorServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public DoctorServices(DoctorRepo doctorRepo) {
		super();
		this.doctorRepo = doctorRepo;
	}
	
	public List<Doctor> findAllDoctors() {
		return doctorRepo.findAll();
	}
	
	public Doctor findDoctorsbyId(int id) throws invalidDoctorIdExection {
		Optional<Doctor> doctor = doctorRepo.findById(id);
		if(!doctor.isPresent()) {
			throw new invalidDoctorIdExection("Branch ID "+id+" is not valid");
			
		}
		return doctor.get();
	}
	
	public Doctor saveDoctors(Doctor doctor) {
		log.debug("doctor created");
		return doctorRepo.save(doctor);
	}
	public Doctor editDoctors(Doctor doctor) throws invalidDoctorIdExection {
		findDoctorsbyId(doctor.getid());
		doctorRepo.save(doctor);
		return doctor;
	}
	public Doctor deleteDoctorsByid(int id) throws invalidDoctorIdExection {
		Doctor doctor = findDoctorsbyId(id);
		doctorRepo.deleteById(id);
		return doctor;
	}
	

	
	
	
	
	
}
