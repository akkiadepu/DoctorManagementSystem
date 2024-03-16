package com.codegnan.entity;




import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="patient")
public class Patient {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	int weight;
	String gender;
	int age;
	String disease;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Patient(String name, int weight, String gender, int age, String disease) {
		super();
		this.name = name;
		this.weight = weight;
		this.gender = gender;
		this.age = age;
		this.disease = disease;
		

	}
	
	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", weight=" + weight + ", gender=" + gender + ", age=" + age
				+ ", disease=" + disease + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	

	
		
	
}
