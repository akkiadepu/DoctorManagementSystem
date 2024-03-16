package com.codegnan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {
	
//	@Query(value = "select * from patient where doctor_id=?1",nativeQuery = true)
	public List<Patient> findAllByDoctor(Doctor doctor);

}
