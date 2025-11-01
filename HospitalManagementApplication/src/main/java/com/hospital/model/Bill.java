package com.hospital.model;


import java.time.LocalDateTime;

public class Bill {
	private int billId;
	private LocalDateTime date;
	private String medicineName;
	private int dosage;
	private Float price;
	
	public Bill(int billId,LocalDateTime date,String medicineName,int dosage,float price){
		this.billId = billId;
		this.date = date;
		this.medicineName = medicineName;
		this.dosage = dosage;
		this.price = price;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getDosage() {
		return dosage;
	}

	public void setDosage(int dosage) {
		this.dosage = dosage;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	
}
