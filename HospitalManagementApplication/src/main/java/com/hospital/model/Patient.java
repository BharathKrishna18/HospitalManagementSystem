package com.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Patient 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;
	
	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	private String gender;
	private LocalDate dob;
	private Double weight;
	private Double height;
	private String bloodGroup;
	private String allergies;
	private String previousMedicalHistory;
	
	public Patient() {}
	
	public Patient(String name, String email, String password, String phoneNumber, String gender, LocalDate dob, Double weight, Double height, String bloodGroup, String allergies, String previousMedicalHistory)
	{
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.dob = dob;
		this.weight = weight;
		this.height = height;
		this.bloodGroup = bloodGroup;
		this.allergies = allergies;
		this.previousMedicalHistory = previousMedicalHistory;
	}
	
	public Long getPateintId()
	{
		return patientId;
	}
	
	
}
