package com.hospital.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.hospital.model.Appointment;
import com.hospital.model.Bill;
import com.hospital.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public String findAdminByIdandPassword(String adminId,String password) {
		String result = adminRepository.validateAdmin(adminId, password);
		return result;
	}
	
	public int registerDoctor(String name,String mobileNumber,String doctorId,String specialization,String password) {
		int saveResult = adminRepository.addDoctorDetails(name,mobileNumber,doctorId,specialization,password);
		return saveResult;
	}
	
	public List<Appointment> getAppointments(){
		List<Appointment> appointments = adminRepository.getAllAppointments();
		return appointments;
	}
	
	public List<Bill> generateBill(int appointmentId){
		List<Bill> patientBill = adminRepository.createBill(appointmentId);
		return patientBill;
	}
}
