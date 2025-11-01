package com.hospital.service;

import org.springframework.stereotype.Service;

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
}
