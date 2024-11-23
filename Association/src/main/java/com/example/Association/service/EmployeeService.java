package com.example.Association.service;

import com.example.Association.entity.Employee;
import com.example.Association.entity.Payment;
import com.example.Association.repo.EmployeeRepo;
import com.example.Association.repo.PaymentRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }

    public Employee addPaymentToEmployee(Integer empId, Payment payment) {
        Employee employee = employeeRepo.findById(empId).get();
        Set<Payment> payments = employee.getPayments();
       payment.setEmployee(employee);
       // payments.add(payment);
        employee.setPayments(payments);
  Payment save = paymentRepo.save(payment);
//        System.out.println("payment Done " + save);
        System.out.println("Employee " + employee);
        return employeeRepo.save(employee);
    }
    public List<Payment> getPaymentsByUser(Integer id)
    {
//        Set<Payment> payments = employeeRepo.getReferenceById(id).getPayments();
//        System.out.println("payments "+payments);

        return paymentRepo.getPaymentsByEmpId(id);
    }
}
