package com.example.DemoProject2.repo;

import com.example.DemoProject2.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepo extends JpaRepository<Demo,Integer> {
}
