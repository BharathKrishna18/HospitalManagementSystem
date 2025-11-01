package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
}
