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
		String sql = "INSERT INTO patient (mobile_number, name, pwd, dob, blood_group, height, weight, allergies, patient_history) "
	               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	     int updatedPatient = jdbcTemplate.update(sql,
	            patient.getPhoneNumber(),        
	            patient.getName(),               
	            patient.getPassword(),                      
	            patient.getDob(),                
	            patient.getBloodGroup(),         
	            patient.getHeight(),             
	            patient.getWeight(),            
	            patient.getAllergies(),          
	            patient.getPreviousMedicalHistory()); 
	     
	     return updatedPatient;
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
	
		
}
