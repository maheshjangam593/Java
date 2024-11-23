package com.example.DBOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpController {

    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    EmpRepository repo;
    private SimpleMailMessage message;


    @PostMapping("/sendMail")
    public ResponseEntity<String> sendMail(@RequestBody Employee employee) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("maheshjangam2727@gmail.com");
        message.setSubject("Birth day offer from marmot avail it");
        message.setText("Hope you are well , you are given discount on your birth login and use");
        emailSender.send(message);
        return new ResponseEntity<>("Mail Sent successfully", HttpStatus.OK);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmploye() {
        List<Employee> employees = repo.findAll();
        return new ResponseEntity<>(employees, HttpStatus.FOUND);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        Optional<Employee> employee = repo.findById(id);
        System.out.println(employee.get());
        return new ResponseEntity<>(employee.get(), HttpStatus.FOUND);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmpployee(@RequestBody Employee employee) {
        Employee employe = repo.save(employee);
        return new ResponseEntity<>(employe, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int id, @RequestBody Employee employee) {
        Optional<Employee> existingEmployee = repo.findById(id);
        existingEmployee.get().setAge(employee.getAge());
        existingEmployee.get().setdeptId(employee.getdeptId());

        Employee updatedEmployee = repo.save(existingEmployee.get());

        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") int id) {
        Optional<Employee> employee = repo.findById(id);

        repo.deleteById(id);
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    @PostMapping("/addEmp")
    public Employee addEmp(@RequestBody Employee employee) {
        return repo.save(employee);
    }


    @GetMapping("/name/{name}")
    public Employee getByName(@PathVariable String name) {
        return repo.findByName(name);

    }

    @GetMapping("/age/{from}/{to}")
    public List<Employee> getByAgeBetween(@PathVariable int from, @PathVariable int to) {
        return repo.findByAgeBetween(from, to);
    }

    @GetMapping("/age/{age}")
    public List<Employee> getAgeGreaterThan(@PathVariable int age) {
        return repo.findByAgeGreaterThan(age);

    }

    @GetMapping("/age")
    public List<Employee> orderByAge() {

        return repo.getEmployeeOrderByAge();
    }

    @GetMapping("/branch/{branch}")
    public List<Employee> getByDept(@PathVariable String branch) {
        return repo.findByDepartmentDeptName(branch);
    }

    @GetMapping("/{name}")
    public List<Employee> getByNames(@PathVariable String name) {
        return repo.getEmployeeByName(name);
    }

    @DeleteMapping("/delete/{name}")
    public int deleteByName(@PathVariable String name) {
        return repo.deleteEmployeeByName(name);
    }

    @PutMapping("/update/{id}")
    public int updateById(@PathVariable int id) {
        return repo.updateEmp(id);
    }

}
