package com.example.myprojectproject.service;

import com.example.myprojectproject.model.Employee;
import com.example.myprojectproject.model.EmployeeLeave;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeLeaveService {
    List<EmployeeLeave> getAllEmployeeLeaves();
    EmployeeLeave getLeaveRequestById(Long id);
    void leaveRequest(EmployeeLeave employeeLeave);
}
