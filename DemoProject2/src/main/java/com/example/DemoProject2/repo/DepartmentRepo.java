package com.example.DemoProject2.repo;

import com.example.DemoProject2.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
