package com.hospital.model;


public class Doctor {
	
	private String doctorId;
	private String password;
	private String name;
	private String speciality;
	private String phonenumber;
	private String email;
	
	
	public Doctor(String doctorId,String password,String name,String speciality,String phonenumber,String email) {
		this.doctorId = doctorId;
		this.password = password;
		this.name = name;
		this.speciality = speciality;
		this.phonenumber = phonenumber;
		this.email = email;
	}


	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
