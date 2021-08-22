package com.example.myprojectproject.controller;

import com.example.myprojectproject.model.Employee;
import com.example.myprojectproject.model.EmployeeLeave;
import com.example.myprojectproject.repository.EmployeeLeaveRepository;
import com.example.myprojectproject.repository.EmployeeRepository;
import com.example.myprojectproject.service.EmployeeLeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeLeaveController {

    @Autowired
    private EmployeeLeaveService employeeLeaveService;
    @Autowired
    private EmployeeLeaveRepository employeeLeaveRepository;


    @GetMapping("/employeeDashboardServlet")
    public String employeeDashboard(Model model) {
        return "employeeDashboard";
    }


    @GetMapping("/showEmployeeLeave")
    public String leaveRequest(Model model) {
        model.addAttribute("leaveRequest",new EmployeeLeave());
        return "leaveRequest";
    }

    @PostMapping("/showEmployeeLeave")
    public String showLeaveRequest(@ModelAttribute("leaveRequest") EmployeeLeave employeeLeave, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        employeeLeave.setEmployee(employee);
        employeeLeave.setLeaveStatus("Pending");
        employeeLeaveRepository.save(employeeLeave);
        return "redirect:/homeView";
    }

    @GetMapping("/showManagementLeaveRequest")
    public String showLeaveRequested(Model model) {
        model.addAttribute("employeeLeaveList", employeeLeaveService.getAllEmployeeLeaves());
        return "managementLeaveDashboard";
    }

    @GetMapping("/rejectLeaveRequest/{id}")
    public String rejectLeaveRequest(@PathVariable( value = "id") long id) {
        EmployeeLeave employeeLeave = employeeLeaveService.getLeaveRequestById(id);
        employeeLeave.setLeaveStatus("Rejected");
        employeeLeaveService.leaveRequest(employeeLeave);
        return "redirect:/showManagementLeaveRequest";
    }

    @GetMapping("/approveLeaveRequest/{id}")
    public String approveLeaveRequest(@PathVariable(value = "id") long id) {
        EmployeeLeave employeeLeave = employeeLeaveService.getLeaveRequestById(id);
        employeeLeave.setLeaveStatus("Approved");
        employeeLeaveService.leaveRequest(employeeLeave);
        return "redirect:/showManagementLeaveRequest";
    }

    @GetMapping("/viewEmployeeLeaveStatus")
        public String viewEmployeeStatus(Model model, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("viewEmployeeLeaveList", employeeLeaveRepository.findEmployeeLeaveByEmployee_Id(employee.getId()));
        return "employeeLeaveStatus";
    }

}
