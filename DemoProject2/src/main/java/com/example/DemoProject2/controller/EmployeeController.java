package com.example.DemoProject2.controller;

import com.example.DemoProject2.entity.Department;
import com.example.DemoProject2.entity.Employe;
import com.example.DemoProject2.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeService employeService;

    @PostMapping("/addEmployee")
    public Employe addEmployee(@RequestBody Employe employe)
    {
        return employeService.addEmployee(employe);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id)
    {
         employeService.deleteEmployee(id);
         return "Employee Deleted Successfully";
    }
    @PostMapping("/department/{dId}/employee/{eId}")
    public Department addEmployeeToTheDepartment(@PathVariable Integer dId, @PathVariable Integer eId)
    {
        return employeService.addEmployeeToTheDepartment(eId,dId);
    }
}
