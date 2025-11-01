package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.service.DoctorService;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor/login")
    public String doctorLoginProcess(Model model, 
                                     @RequestParam("doctorId") String doctorId, 
                                     @RequestParam("password") String password) {
        String doctorName = doctorService.validateByIdandPassword(doctorId, password);

        if (doctorName != null) {
            model.addAttribute("doctorname", doctorName);
            return "doctor-dashboard";  // name of your Thymeleaf HTML page
        } else {
            model.addAttribute("error", "Invalid doctor ID or password");
            return "doctor-login"; // show login page again
        }
    }
}
