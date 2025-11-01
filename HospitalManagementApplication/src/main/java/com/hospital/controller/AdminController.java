package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/login")
	public String processAdminLogin(@RequestParam("adminId") String adminId,
			@RequestParam("password") String password,Model model) {
			
		String result = adminService.findAdminByIdandPassword(adminId,password);
		if(result!=null) {
			model.addAttribute("adminname", result);
			return "dashboard-admin";
			
		}else {
			return "admin-login";
		}
	}
	
	@GetMapping("/admin/login/doctor_registration")
	public String doctorForm() {
	    return "admin_doctor_registration";
	}

	@PostMapping("/admin/login/doctor_registration")
	public String doctorRegistration(@RequestParam("docId") String doctorId,
			@RequestParam("docName") String doctorName,
			@RequestParam("mobile") String mobileNumber,
			@RequestParam("specialisation") String specialization,
			@RequestParam("password") String password,
			Model model) {
		int result = adminService.registerDoctor(doctorName,mobileNumber,doctorId,specialization,password);
		
		if(result > 0) {
			model.addAttribute("message", "Doctor Successfully Registered!");
			
		}else {
			model.addAttribute("message", "Failed to register doctor details");
		}
		
		return "admin_doctor_registration";
	}
}
