package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patients")
public class PatientController 
{
	 @Autowired
	    private PatientRepository patientRepository;
	 
	 //RegisterPatient
	 @GetMapping("/registerPatient")
	 public String showRegistrationForm(Model model)
	 {
		 model.addAttribute("patient", new Patient());
		 return "patient-profile";
	 }
	 
	 @PostMapping("/register")
	 public String registerPatient(@ModelAttribute("patient") Patient patient,RedirectAttributes redirectAttributes) 
	 {
	        int result = patientRepository.registerPatient(patient);

	        if (result > 0) {
	            redirectAttributes.addFlashAttribute("success", "Registration successful! Please log in.");
	            return "redirect:/patients/login";
	        } else {
	            redirectAttributes.addFlashAttribute("error", "Registration failed. Try again!");
	            return "redirect:/patients/register";
	        }
	    }
	
}
