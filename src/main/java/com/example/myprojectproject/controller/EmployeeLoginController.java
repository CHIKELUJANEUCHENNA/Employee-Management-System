package com.example.myprojectproject.controller;

import com.example.myprojectproject.dto.EmployeeLoginDto;
import com.example.myprojectproject.model.Employee;
import com.example.myprojectproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class EmployeeLoginController {

    @Autowired
    public EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String employeeLogin(Model model) {
        model.addAttribute("employeeLogin", new EmployeeLoginDto());
        System.out.println("just checking");
        return "index";
    }

    @PostMapping("/login")
    public String employeeLogin(@ModelAttribute("employeeLogin") EmployeeLoginDto employeeLoginDto, HttpSession session, BindingResult result,Model model){
        if (result.hasErrors()) {
            return "index";
        }
        System.out.println("before status");
        Employee status = employeeRepository.findEmployeeByEmailAndPassword(employeeLoginDto.getEmail(), employeeLoginDto.getPassword());
        if (status != null) {
            System.out.println(status);
            session.setAttribute("employee", status);
                return "redirect:homeView";
        } else {
            return "index";
        }
    }
}
