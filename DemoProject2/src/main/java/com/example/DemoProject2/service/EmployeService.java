package com.example.DemoProject2.service;

import com.example.DemoProject2.entity.Department;
import com.example.DemoProject2.entity.Employe;
import com.example.DemoProject2.exception.DepartMentNotFoundException;
import com.example.DemoProject2.exception.EmployeeNotFoundException;
import com.example.DemoProject2.repo.DepartmentRepo;
import com.example.DemoProject2.repo.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmployeService {

    @Autowired
    private EmployeRepo employeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;
    public Employe addEmployee(Employe employe)
    {
        // Demo demo = modelMapper.map(demoDto, Demo.class);

        return employeRepo.save(employe);
    }
    public void deleteEmployee(Integer id)
    {
        // Demo demo = modelMapper.map(demoDto, Demo.class);

       employeRepo.deleteById(id);
    }
    public Department addEmployeeToTheDepartment(Integer eId, Integer dId)
    {
        Set<Employe> employeSet;

        Employe employe = employeRepo.findById(eId).orElseThrow(() -> new EmployeeNotFoundException(eId));
        Department department = departmentRepo.findById(dId).orElseThrow(() -> new DepartMentNotFoundException(dId));
        Set<Employe> employe1 = department.getEmploye();
        employe.setDepartment(department);
        System.out.println("Employees in deparment "+ employe1);
        employe1.add(employe);
        //Employe save = employeRepo.save(employe);

        department.setEmploye(employe1);

        employeRepo.save(employe);
        System.out.println("department "+ department);
        return departmentRepo.save(department);
    }
}
