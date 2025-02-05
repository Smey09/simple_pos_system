package com.example.pos_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pos_system.models.Payment;
import com.example.pos_system.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(String payment_id) {
        return paymentRepository.findById(payment_id);
    }

    public void deleteById(String payment_id) {
        paymentRepository.deleteById(payment_id);
    }

    public Payment updatePayment(String payment_id, Payment updatedPayment) {
        return paymentRepository.findById(payment_id).map(payment -> {
            payment.setOrder_id(updatedPayment.getOrder_id());
            payment.setPayment_type(updatedPayment.getPayment_type());
            payment.setPayment_amount(updatedPayment.getPayment_amount());
            payment.setPain_at(updatedPayment.getPain_at());
            return paymentRepository.save(payment);
        }).orElseGet(() -> {
            updatedPayment.setPayment_id(payment_id);
            return paymentRepository.save(updatedPayment);
        });
    }

}
