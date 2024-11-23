package com.example.DBOperations;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Data
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        @Column(name="dept_Name")
    private String deptName;
    private int age;
    @Column(name="dept_Id")
    private int deptId;
    @OneToOne(targetEntity = Department.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "department_dept_Id", referencedColumnName = "dept_Id")
    private Department department;
    public Employee() {
    }

    public Employee(int i, String raja, int i1, int i2, Department o) {
        this.id=i;
        this.deptName=raja;
        this.age=i1;
        this.deptId=i2;
        this.department=o;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getdeptId() {
        return deptId;
    }

    public void setdeptId(int id) {
        this.deptId = id;
    }



    public String getDept() {
        return deptName;
    }

    public void setDept(String dept) {
        this.deptName = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
