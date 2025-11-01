package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hospital.repository.DoctorRepository;

@Controller
public class AuthController {
	
	
	@GetMapping("/")
	public String loginForm() {
		
		return "login";
	}
	
	@GetMapping("/doctor/login")
	public String doctorLoginPage() {
		return "doctor-login";
	}
	
	@GetMapping("/admin/login")
	public String adminLoginPage() {
		
		return "admin-login";
	}
	
}
