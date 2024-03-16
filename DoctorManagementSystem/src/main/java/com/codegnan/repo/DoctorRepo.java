package com.codegnan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codegnan.entity.Doctor;
import com.codegnan.entity.Patient;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer> {
	

	

	
}
