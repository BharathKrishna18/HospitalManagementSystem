package com.hospital.model;

import java.time.LocalDate;

public class Patient 
{
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
	
	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}
	
	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDob() 
	{
		return dob;
	}

	public void setDob(LocalDate dob) 
	{
		this.dob = dob;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public Double getWeight() 
	{
		return weight;
	}

	public void setWeight(Double weight) 
	{
		this.weight = weight;
	}

	public Double getHeight() 
	{
		return height;
	}

	public void setHeight(Double height) 
	{
		this.height = height;
	}

	public String getBloodGroup() 
	{
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) 
	{
		this.bloodGroup = bloodGroup;
	}

	public String getAllergies() 
	{
		return allergies;
	}

	public void setAllergies(String allergies) 
	{
		this.allergies = allergies;
	}

	public String getPreviousMedicalHistory() 
	{
		return previousMedicalHistory;
	}

	public void setPreviousMedicalHistory(String previousMedicalHistory) 
	{
		this.previousMedicalHistory = previousMedicalHistory;
	}
}
