package com.hospital.model;

public class Medication {

    private int appointmentId;
    private String medicineName;
    private int quantity;

    public Medication(int appointmentId, String medicineName, int quantity) {
        this.appointmentId = appointmentId;
        this.medicineName = medicineName;
        this.quantity = quantity;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
            this.quantity = quantity; 
    }
}

