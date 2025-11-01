package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.model.Invoice;
import com.hospital.repository.PatientRepository;
import com.hospital.service.InvoiceService;
import com.hospital.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private InvoiceService invoiceService;
    
    @Autowired
    private PatientService patientService;

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String phoneNumber,
                        @RequestParam String password,
                        Model model,
                        RedirectAttributes redirectAttributes) {

        Patient patient = patientRepository.findPatientByPhoneAndPassword(phoneNumber, password);
        if (patient != null) {
            model.addAttribute("patient", patient);
            return "dashboard-patient";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid phone number or password!");
            return "redirect:/patient/register";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-profile";
    }

    @PostMapping("/register")
    public String registerPatient(@ModelAttribute Patient patient,
                                  @RequestParam String confirmPassword,
                                  RedirectAttributes redirectAttributes) {

        if (!patient.getPassword().equals(confirmPassword)) 
        {
            redirectAttributes.addFlashAttribute("error", "Passwords do not match!");
            return "redirect:/patient/register";
        }

        int result = patientRepository.registerPatient(patient);

        if (result > 0) 
        {
            redirectAttributes.addFlashAttribute("success", "Registration successful! Please log in.");
            return "redirect:/patient/login";
        } 
        else 
        {
            redirectAttributes.addFlashAttribute("error", "Registration failed! Try again!");
            return "redirect:/patient/register";
        }
    }
    
    @PostMapping("/saveProfile")
    public String saveProfile(@ModelAttribute Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patient/dashboard-patient";
    }

    @GetMapping("/dashboard/{id}")
    public String patientDashboard(@PathVariable Long id, Model model) {
        Patient patient = patientRepository.getPatientById(id);
        model.addAttribute("patient", patient);
        return "dashboard-patient";
    }

    @GetMapping("/appointment/{id}")
    public String showAppointmentPage(@PathVariable Long id, Model model) {
        Patient patient = patientRepository.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patient_appointment";
    }

    @PostMapping("/appointment/book")
    public String bookAppointment(@RequestParam Long patientId,
                                  @RequestParam String doctorName,
                                  @RequestParam String date,
                                  @RequestParam String time,
                                  RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "Appointment booked successfully!");
        return "redirect:/patient/dashboard/" + patientId;
    }

    @GetMapping("/update/{id}")
    public String showUpdatePage(@PathVariable Long id, Model model) {
        Patient patient = patientRepository.getPatientById(id);
        model.addAttribute("patient", patient);
        return "patient-update";
    }

    @PostMapping("/update")
    public String updatePatient(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {
        int result = patientRepository.updatePatient(patient);
        if (result > 0) {
            redirectAttributes.addFlashAttribute("success", "Profile updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Profile update failed!");
        }

        return "redirect:/patient/dashboard/" ;
    }

    @GetMapping("/bills/{id}")
    public String viewBills(@PathVariable Long id, Model model) {
        List<Invoice> invoices = invoiceService.getInvoicesByPatientId(id);
        model.addAttribute("patientId", id);
        model.addAttribute("invoices", invoices);
        return "patient-bills";
    }
}
