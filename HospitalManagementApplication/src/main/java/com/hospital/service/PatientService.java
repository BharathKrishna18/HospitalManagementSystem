package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public int registerPatient(Patient patient) 
    {
        return patientRepository.registerPatient(patient);
    }

    public Patient loginPatient(String email, String password) 
    {
        return patientRepository.findPatientByPhoneAndPassword(email, password);
    }

    public Patient getPatientById(Long id) 
    {
        return patientRepository.getPatientById(id);
    }

    public int updatePatient(Patient patient)
    {
        return patientRepository.updatePatient(patient);
    }
}
