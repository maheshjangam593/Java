package com.example.DemoProject2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eId;
    @Column(name = "eM_Name")
    private String name;
    private long salary;
    @ManyToOne()
    @JoinColumn(name = "DeptId")
    private Department department;
}
