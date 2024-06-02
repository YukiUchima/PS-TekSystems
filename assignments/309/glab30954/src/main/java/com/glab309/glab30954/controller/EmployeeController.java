package com.glab309.glab30954.controller;

import com.glab309.glab30954.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {

    private Map<Long, Employee> employeeMap = new HashMap<>();

    @GetMapping("/employeeform")
    public String empForm(){
        return "employeeform";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute("employee") Employee newEmployee, ModelMap model){
        model.addAttribute("name", newEmployee.getName());
        model.addAttribute("id", newEmployee.getId());
        model.addAttribute("contactNumber", newEmployee.getContactNumber());
        employeeMap.put(newEmployee.getId(), newEmployee);
        return "employeeView";
    }
}
