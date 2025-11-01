package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.model.Appointment;
import com.hospital.model.Bill;
import com.hospital.service.AdminService;
import java.util.*
;@Controller

public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin/login")
	public String processAdminLogin(@RequestParam("adminId") String adminId,
			@RequestParam("password") String password,Model model) {
		
		
		String result = adminService.findAdminByIdandPassword(adminId,password);
		if(result!=null) {
			List<Appointment> todayAppointments = adminService.getAppointments();
			
			if(todayAppointments!=null) {
				model.addAttribute("todayAppointments",todayAppointments);
			}
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
	
	@GetMapping("/admin/bill")
	public String adminBillView(
			@RequestParam("id") int id,
			@RequestParam("doctorName") String doctorName,
			@RequestParam("patientName") String patientName,
			Model model
			) {
		
		List<Bill> generatedBill = adminService.generateBill(id);
		
		double totalAmount = 0.0;
		 if (generatedBill != null && !generatedBill.isEmpty()) {
		        totalAmount = generatedBill.stream()
		            .mapToDouble(b -> b.getPrice())
		            .sum();
		    }
		model.addAttribute("id",id);
		model.addAttribute("bills",generatedBill);
		model.addAttribute("doctorName",doctorName);
		model.addAttribute("patientName",patientName);
		model.addAttribute("totalAmount",totalAmount+1000);
		return "admin_bill";
	}
}
