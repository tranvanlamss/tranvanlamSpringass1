package com.example.assignmentspring.controller;

import com.example.assignmentspring.dto.EmployeeDTO;
import com.example.assignmentspring.entity.EmployeeEntity;
import com.example.assignmentspring.service.EmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @GetMapping({"/","/index"})
    public String listEmployee(Model model){
        List<EmployeeEntity> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "redirect:/index";
    }

    @GetMapping("/create")
    public String formCreate(Model model){
        EmployeeDTO employee = new EmployeeDTO();
        model.addAttribute("employee", employee);
        return "create";
    }

    @PostMapping("/create")
    public String createEmployee(Model model, @ModelAttribute EmployeeDTO employeeDTO){
        if (employeeDTO != null){
            employeeService.createEmployee(employeeDTO);
        }
        return "redirect:/index";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteProduct(id);
        return "redirect:/";
    }

}
