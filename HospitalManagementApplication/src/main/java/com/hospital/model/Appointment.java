package com.hospital.model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
	
	private int appointmentId;
    private String patientName;
    private String doctorName;
    private Date appointmentDate;
    private Time timeSlot;
    private String status;

    public Appointment(String patientName, Date appointmentDate, Time timeSlot,String status) {
        this.patientName = patientName;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
    }
    
    public Appointment(int appointmentId,String doctorName,String patientName,Time timeSlot) {
    		this.appointmentId = appointmentId;
    		this.doctorName = doctorName;
    		this.patientName = patientName;
    		this.timeSlot = timeSlot;
    }
    
    public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Time timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
