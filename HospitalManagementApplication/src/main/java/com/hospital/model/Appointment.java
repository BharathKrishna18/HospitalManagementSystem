package com.hospital.model;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private String name;
    private Date appointmentDate;
    private Time timeSlot;
    private String status;

    public Appointment(String name, Date appointmentDate, Time timeSlot,String status) {
        this.name = name;
        this.appointmentDate = appointmentDate;
        this.timeSlot = timeSlot;
        this.status = status;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
