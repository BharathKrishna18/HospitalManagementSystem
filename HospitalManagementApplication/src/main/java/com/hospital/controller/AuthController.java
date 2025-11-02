package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hospital.model.Patient;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.PatientRepository;

@Controller
public class AuthController {
	
	@Autowired
    private PatientRepository patientRepository;
	
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
	
    @GetMapping("/patient/login")
    public String patientLoginForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-login";
    }

}
