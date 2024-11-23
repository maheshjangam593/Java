package com.example.Association.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude = {"payments"})

public class Employee {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private String name;
    private long salary;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
   // @JsonBackReference
    private Set<Payment> payments;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id && salary == employee.salary && name.equals(employee.name) && payments.equals(employee.payments);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, salary, payments);
//    }
}
