package com.hospital.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hospital.model.Appointment;
import com.hospital.model.Bill;

import java.util.*
;@Repository

public class AdminRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String validateAdmin(String adminId,String password) {
		try {
			String sql = "select name from admin where adminid= ? and password = ?";
			return jdbcTemplate.queryForObject(sql,String.class,adminId,password);
		}catch(Exception exception) {
			return "Invalid Credentials";
		}
	}
	
	public int addDoctorDetails(String name,String mobileNumber,String doctorId,String specialization,String password) {
		try {
			
			String sql = "insert into doctor values(?,?,?,?,?)";
			return jdbcTemplate.update(sql,doctorId,password,specialization,mobileNumber,name);
			
		}catch(Exception exception) {
			return 0;
		}
	}
	
	public List<Appointment> getAllAppointments(){
		try {
			String sql = """ 
					select a.appointment_id as appointmentId, 
					d.name as doctorName,
					p.name as patientName,
					a.time_slot as timeSlot from appointment a 
					join patient p on a.patient_mobile = p.mobile_number 
					join doctor d on a.doctor_username = d.doctorId
					""";
			
			return jdbcTemplate.query(sql, (rs, rowNum) ->
	        new Appointment(
	        		rs.getInt("appointmentId"),
	            rs.getString("doctorName"),
	            rs.getString("patientName"),
	            rs.getTime("timeSlot")
	        )
	    );
		}catch(Exception exception) {
				return null;
		}
	}
	
	public List<Bill> createBill(int appointmentId){
		String sql = """
			    SELECT 
			        invoice_id AS billId,
			        date_issued AS dateIssued,
			        medicine_name AS medicine,
			        quantity AS dosage,
			        amount AS price
			    FROM medication 
			    NATURAL JOIN invoice 
			    WHERE appointment_id = ?
			""";

			try {
				
			    return jdbcTemplate.query(sql, (rs, rowNum) ->
			        new Bill(
			            rs.getInt("billId"),
			            rs.getTimestamp("dateIssued").toLocalDateTime(),
			            rs.getString("medicine"),
			            rs.getInt("dosage"),
			            rs.getFloat("price")
			        ), appointmentId
			    );
			}catch(Exception exception) {
			return null;
		}
	}
}
