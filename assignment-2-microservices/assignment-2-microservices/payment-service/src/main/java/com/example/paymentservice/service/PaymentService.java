package com.example.paymentservice.service;

import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found"));
    }

    public Payment createPayment(Payment payment) {
        payment.setId(null);
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment existing = getPaymentById(id);
        existing.setStudentId(updatedPayment.getStudentId());
        existing.setEnrollmentId(updatedPayment.getEnrollmentId());
        existing.setAmount(updatedPayment.getAmount());
        existing.setPaymentDate(updatedPayment.getPaymentDate());
        existing.setPaymentStatus(updatedPayment.getPaymentStatus());
        return paymentRepository.save(existing);
    }

    public void deletePayment(Long id) {
        try {
            paymentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment not found");
        }
    }
}
