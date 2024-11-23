package com.example.Association.repo;

import com.example.Association.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {

    @Query(value = "select * from PAYMENT p where p.emp_fk_id=:id", nativeQuery = true)
    public List<Payment> getPaymentsByEmpId(Integer id) ;



}
