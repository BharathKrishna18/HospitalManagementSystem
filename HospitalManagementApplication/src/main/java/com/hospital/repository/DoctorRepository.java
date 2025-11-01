package com.hospital.repository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hospital.model.Appointment;

import java.sql.*;

@Repository
public class DoctorRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public String findDoctorByIdandPassword(String doctorId,String password) {
		String sql = "select name from doctor where doctorId = ? and password = ?";
		try {
			return jdbcTemplate.queryForObject(sql,String.class,doctorId,password);
		}catch(Exception exception) {
			return null;
		}
	}
	
	public List<Appointment> getAppointmentsByDoctorId(String doctorId){
		
		String sql = """
		        select name, date, time_slot, status
		        from patient
		        join appointment on patient.mobile_number = appointment.patient_mobile
				where doctor_username = ?
		    """;
		
		try {
			return jdbcTemplate.query(sql, (rs, rowNum) ->
	        new Appointment(
	            rs.getString("name"),
	            rs.getDate("date"),       
	            rs.getTime("time_slot"),
	            rs.getString("status")
	        ),
	        doctorId
	    );
		}catch(Exception exception) {
			return null;
		}
		
	}
}
