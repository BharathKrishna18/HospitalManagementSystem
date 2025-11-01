package com.hospital.model;

import java.time.LocalDate;

public class Invoice {

    private int invoiceId;
    private int appointmentId;
    private double amount;
    private LocalDate dateIssued;
    private String paymentStatus;

    public Invoice(int invoiceId, int appointmentId, double amount, LocalDate dateIssued, String paymentStatus) {
        this.invoiceId = invoiceId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.dateIssued = dateIssued;
        this.paymentStatus = paymentStatus;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}

