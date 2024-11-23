package com.example.DemoProject2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dId;
    @Column(name = "dA_Name")
    private String name;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Employe> employe;

}
