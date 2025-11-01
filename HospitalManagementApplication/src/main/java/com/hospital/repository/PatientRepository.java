package com.hospital.repository;

import com.hospital.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository 
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//Register
	public int registerPatient(Patient patient)
	{
		String sql = "INSERT INTO patient (name, email, password, phone_number, gender, dob, weight, height, blood_group, allergies, previous_medical_history) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	     int registeredPatient = jdbcTemplate.update(sql,
	            patient.getPhoneNumber(),        
	            patient.getName(),               
	            patient.getPassword(),                      
	            patient.getDob(),                
	            patient.getBloodGroup(),         
	            patient.getHeight(),             
	            patient.getWeight(),            
	            patient.getAllergies(),          
	            patient.getPreviousMedicalHistory()); 
	     
	     return registeredPatient;
	}
	
	//login
	public String findPatientByIdandPassword(String email,String password) 
	{
		String sql = "SELECT name FROM patient WHERE email = ? and password = ?";
		try 
		{
			return jdbcTemplate.queryForObject(sql,String.class,email,password);
		}
		catch(Exception e) 
		{
			return "Invalid Credentials";
		}
	}
	
	//display all patients
	public List<Patient> getAllPatients()
	{
		String sql = "SELECT * FROM patient";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Patient.class));
	}
	
	//display one patient by id
	public Patient getPatientById(Long id) 
	{
        String sql = "SELECT * FROM patient WHERE patient_id = ?";
        try 
        {
            return jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(Patient.class),
                    id);
        } 
        catch (Exception e) 
        {
            return null;
        }
    }
	
	//update patient
    public int updatePatient(Patient patient) 
    {
        String sql = "UPDATE patient SET name = ?, email = ?, phone_number = ?, gender = ?, dob = ?, weight = ?, height = ?, blood_group = ?, allergies = ?, previous_medical_history = ? WHERE patient_id = ?";

        int updatedPatient = jdbcTemplate.update(sql,
                patient.getName(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getGender(),
                patient.getDob(),
                patient.getWeight(),
                patient.getHeight(),
                patient.getBloodGroup(),
                patient.getAllergies(),
                patient.getPreviousMedicalHistory(),
                patient.getPateintId());
        return updatedPatient;
    }
}
