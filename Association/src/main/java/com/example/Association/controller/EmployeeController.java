package com.example.Association.controller;

import com.example.Association.entity.Employee;
import com.example.Association.entity.Payment;
import com.example.Association.service.EmployeeService;
import com.example.Association.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return "Employee with Id "+id +" deleted Successfully";
    }
    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable Integer id) {

        return paymentService.deletPaymentById(id);
    }

    @PostMapping("/employee/{id}/addPayment")
    public Employee addPaymentToEmployee(@PathVariable Integer id, @RequestBody Payment payment) {
        return employeeService.addPaymentToEmployee(id, payment);
    }

    @GetMapping("/employee/{id}/getPayments")
    public List<Payment> getPaymentByUser(@PathVariable Integer id)
    {
      return  employeeService.getPaymentsByUser(id);
    }

    @GetMapping("/payments/{id}")
    public Payment getPaymentById(@PathVariable Integer id)
    {
        return paymentService.getPaymentById(id);
    }


}
