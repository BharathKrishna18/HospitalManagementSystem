package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.model.Appointment;
import com.hospital.repository.DoctorRepository;
import java.util.*;
@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public String validateByIdandPassword(String doctorId,String password) {
		String result = doctorRepository.findDoctorByIdandPassword(doctorId,password);
		return result;
	}
	
	public List<Appointment> findAppointmentsByDoctorId(String doctorId){
		List<Appointment> appointments = new ArrayList<Appointment>();
		appointments = doctorRepository.getAppointmentsByDoctorId(doctorId);
		
		return appointments;
	}
}
