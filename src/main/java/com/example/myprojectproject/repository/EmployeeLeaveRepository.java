package com.example.myprojectproject.repository;

import com.example.myprojectproject.model.EmployeeLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeLeaveRepository extends JpaRepository<EmployeeLeave, Long> {
//    @Override
    List<EmployeeLeave> findEmployeeLeaveByEmployee_Id(Long aLong);
}
