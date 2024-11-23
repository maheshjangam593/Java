package com.example.DemoProject2.repo;

import com.example.DemoProject2.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employe,Integer> {
}
