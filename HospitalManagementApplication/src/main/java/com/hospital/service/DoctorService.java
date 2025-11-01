package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	public String validateByIdandPassword(String doctorId,String password) {
		String result = doctorRepository.findDoctorByIdandPassword(doctorId,password);
		return result;
	}
}
