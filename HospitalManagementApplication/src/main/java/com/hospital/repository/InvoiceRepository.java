package com.hospital.repository;

import com.hospital.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceRepository 
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private RowMapper<Invoice> invoiceMapper = new RowMapper<>()
    {
    	@Override
    	public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException 
    	{
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(rs.getInt("invoice_id"));         
            invoice.setPatientId(rs.getInt("patient_id"));        
            invoice.setAppointmentId(rs.getInt("appointment_id")); 
            invoice.setAmount(rs.getDouble("amount"));

            if (rs.getDate("date_issued") != null) 
            {
                invoice.setDateIssued(rs.getDate("date_issued").toLocalDate());
            } 
            else 
            {
                invoice.setDateIssued(null);
            }

            invoice.setPaymentStatus(rs.getString("payment_status"));
            return invoice;
        }
    };
    
    //Fetch all invoices for a patient
    public List<Invoice> findByPatientId(Long patientId) 
    {
        String sql = "SELECT * FROM invoice WHERE patient_id = ?";
        return jdbcTemplate.query(sql, invoiceMapper, patientId);
    }
    
    //Add Invoice
    public int addInvoice(Invoice invoice) 
    {
        String sql = "INSERT INTO invoice (patient_id, appointment_id, amount, date_issued, payment_status) VALUES (?, ?, ?, ?, ?)";
        int addInvoiceVal = jdbcTemplate.update(sql,
                invoice.getPatientId(),
                invoice.getAppointmentId(),
                invoice.getAmount(),
                invoice.getDateIssued(),
                invoice.getPaymentStatus());
        return addInvoiceVal;
    }
    
    //Update payment specifics
    public int updatePaymentStatus(int invoiceId, String status) 
    {
        String sql = "UPDATE invoice SET payment_status = ? WHERE invoice_id = ?";
        return jdbcTemplate.update(sql, status, invoiceId);
    }
}
