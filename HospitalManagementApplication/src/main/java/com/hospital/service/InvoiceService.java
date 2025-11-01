package com.hospital.service;

import com.hospital.model.Invoice;
import com.hospital.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService 
{
	@Autowired
    private InvoiceRepository InvoiceRepository;
	
	public List<Invoice> getInvoicesByPatientId(Long patientId) 
	{
        return InvoiceRepository.findByPatientId(patientId);
    }
	
	public int addInvoice(Invoice invoice) 
	{
        return InvoiceRepository.addInvoice(invoice);
    }
	
	public int updatePaymentStatus(int invoiceId, String status) 
	{
        return InvoiceRepository.updatePaymentStatus(invoiceId, status);
    }
}
