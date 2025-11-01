package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.model.Appointment;
import com.hospital.service.DoctorService;
import java.util.*;

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
            List<Appointment> appointments = doctorService.findAppointmentsByDoctorId(doctorId);
            
            model.addAttribute("appointments",appointments);
            return "doctor-dashboard"; 
        } else {
            model.addAttribute("error", "Invalid Credentials");
            return "doctor-login"; // show login page again
        }
    
    }
    
    
}
