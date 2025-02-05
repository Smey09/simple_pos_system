package com.example.pos_system.service;

import com.example.pos_system.models.Customer;
import com.example.pos_system.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String customer_id) {
        return customerRepository.findById(customer_id);
    }

    public Customer updateCustomer(String customer_id, Customer updatedCustomer) {
        return customerRepository.findById(customer_id).map(customer -> {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setCreate_at(updatedCustomer.getCreate_at());
            return customerRepository.save(customer);
        }).orElseGet(() -> {
            updatedCustomer.setId(customer_id);
            return customerRepository.save(updatedCustomer);
        });
    }

    public void deleteCustomer(String customer_id) {
        customerRepository.deleteById(customer_id);
    }
}
