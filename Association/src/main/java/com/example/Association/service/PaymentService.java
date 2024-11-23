package com.example.Association.service;

import com.example.Association.entity.Payment;
import com.example.Association.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    public Payment getPaymentById(Integer id)
    {
        Payment payment = paymentRepo.findById(id).get();
        System.out.println("payment by ID "+payment);
        return payment;
    }

    public String deletPaymentById(Integer id)
    {
        paymentRepo.deleteById(id);
        return "deleted payment with id " + id;
    }
}
