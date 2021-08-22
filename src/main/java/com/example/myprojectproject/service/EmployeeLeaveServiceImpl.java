package com.example.myprojectproject.service;

import com.example.myprojectproject.model.EmployeeLeave;
import com.example.myprojectproject.repository.EmployeeLeaveRepository;
import com.example.myprojectproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService{

    @Autowired
    private EmployeeLeaveRepository employeeLeaveRepository;

    @Override
    public List<EmployeeLeave> getAllEmployeeLeaves() {
        return employeeLeaveRepository.findAll();
    }

    @Override
    public EmployeeLeave getLeaveRequestById(Long id) {
        Optional<EmployeeLeave> leave = employeeLeaveRepository.findById(id);
        EmployeeLeave employeeLeave;
        if(leave.isPresent()) {
            employeeLeave = leave.get();
        } else {
            throw new RuntimeException("Request not found:"+ id);
        }
        return employeeLeave;
    }

    @Override
    public void leaveRequest(EmployeeLeave employeeLeave) {
        employeeLeaveRepository.save(employeeLeave);
    }
}
