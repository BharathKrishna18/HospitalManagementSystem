package com.hospital.repository;

import com.hospital.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ✅ Register Patient
    public int registerPatient(Patient patient) {
        String sql = "INSERT INTO patient (name, mobile_number, pwd, blood_group, height, weight, allergies, patient_history) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                patient.getName(),
                patient.getPhoneNumber(),
                patient.getPassword(),
                patient.getBloodGroup(),
                patient.getHeight(),
                patient.getWeight(),
                patient.getAllergies(),
                patient.getPreviousMedicalHistory());
    }

    // ✅ Login using phone number and password
    public Patient findPatientByPhoneAndPassword(String phoneNumber, String password) {
        String sql = "SELECT * FROM patient WHERE mobile_number = ? AND pwd = ?";
        try {
            return jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Patient.class),
                    phoneNumber, password);
        } catch (Exception e) {
            return null;
        }
    }

    // ✅ Display all patients
    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patient";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Patient.class));
    }

    // ✅ Get one patient by ID
    public Patient getPatientById(Long id) {
        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Patient.class),
                    id);
        } catch (Exception e) {
            return null;
        }
    }

    // ✅ Update patient details (only columns your DB actually has)
    public int updatePatient(Patient patient) {
        String sql = "UPDATE patient SET name = ?, mobile_number = ?, pwd = ?, blood_group = ?, height = ?, weight = ?, allergies = ?, patient_history = ? WHERE patient_id = ?";
        return jdbcTemplate.update(sql,
                patient.getName(),
                patient.getPhoneNumber(),
                patient.getPassword(),
                patient.getBloodGroup(),
                patient.getHeight(),
                patient.getWeight(),
                patient.getAllergies(),
                patient.getPreviousMedicalHistory(),
                patient.getPatientId());
    }
}
