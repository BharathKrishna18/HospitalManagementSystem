package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.model.Invoice;
import com.hospital.repository.PatientRepository;
import com.hospital.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/loginPatient")
    public String showLoginPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-login";
    }

    @PostMapping("/loginPatient")
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
            return "redirect:/patients/registerPatient";
        }
    }

    @GetMapping("/registerPatient")
    public String showRegistrationForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-profile";
    }

    @PostMapping("/registerPatient")
    public String registerPatient(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {
        int result = patientRepository.registerPatient(patient);
        if (result > 0) {
            redirectAttributes.addFlashAttribute("success", "Registration successful! Please log in.");
            return "redirect:/patients/loginPatient";
        } else {
            redirectAttributes.addFlashAttribute("error", "Registration failed! Try again!");
            return "redirect:/patients/registerPatient";
        }
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
        return "redirect:/patients/dashboard/" + patientId;
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

        return "redirect:/patients/dashboard/" ;
    }

    @GetMapping("/bills/{id}")
    public String viewBills(@PathVariable Long id, Model model) {
        List<Invoice> invoices = invoiceService.getInvoicesByPatientId(id);
        model.addAttribute("patientId", id);
        model.addAttribute("invoices", invoices);
        return "patient-bills";
    }
}
