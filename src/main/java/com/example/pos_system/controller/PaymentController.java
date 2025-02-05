package com.example.pos_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos_system.models.Orders;
import com.example.pos_system.models.Payment;
import com.example.pos_system.service.OrderService;
import com.example.pos_system.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1.0.0/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment() {
        try {
            List<Payment> paymentData = paymentService.getAllPayments();

            if (paymentData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(paymentData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/{payment_id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String payment_id) {
        try {
            Optional<Payment> paymentData = paymentService.getPaymentById(payment_id);

            if (paymentData.isPresent()) {
                return new ResponseEntity<>(paymentData.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody Payment payment) {
        try {
            // Extract order_id from orders
            String orderId = payment.getOrder_id();

            // Find order by their IDs
            Optional<Orders> orderData = orderService.getOrderById(orderId);

            if (orderData.isEmpty()) {
                return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
            }

            // Save the order
            Payment savedPayment = paymentService.addPayment(payment);
            return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
