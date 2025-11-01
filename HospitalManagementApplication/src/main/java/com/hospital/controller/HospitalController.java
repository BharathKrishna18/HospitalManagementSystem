package com.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {

	@GetMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("welcome", "Welcome to ABC Hospital:)");
		return "welcome";
	}
	
	
}
