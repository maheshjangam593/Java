package com.example.DBOperations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee, Integer> {


    @Query(value = "SELECT * FROM Employee e WHERE e.dept_Name=?1", nativeQuery = true)
    Employee findByName(String name);

    public List<Employee> findByAgeBetween(int a, int b);

    // @Query(value = "select * from employee where age>?1",nativeQuery = true)
    List<Employee> findByAgeGreaterThan(int a);

    @Query(value = "select * from employee order by age", nativeQuery = true)
    List<Employee> getEmployeeOrderByAge();

    List<Employee> findByDepartmentDeptName(String name);

    @Query(value = "select * from employee e join department d on e.dept_Id=d.dept_Id where d.dept_Name=?1", nativeQuery = true)
    List<Employee> getEmployeeByName(String name);

    @Modifying
    @Transactional
    @Query(value = "delete Employee e where e.dept_Name=:name", nativeQuery = true)
    int deleteEmployeeByName(String name) ;

    @Modifying
   @Transactional
    @Query(value = "update Employee e set e.dept_Name='Mahi' where e.dept_Id=?1", nativeQuery = true)
    int updateEmp(int id);
}
