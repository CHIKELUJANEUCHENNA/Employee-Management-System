package com.example.myprojectproject.repository;

import com.example.myprojectproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findEmployeeByEmailAndPassword(String email, String password);
}
