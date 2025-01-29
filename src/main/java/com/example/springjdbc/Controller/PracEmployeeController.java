package com.example.springjdbc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springjdbc.Repositly.PracEmployeeRepository;
import com.example.springjdbc.domain.PracEmployee;

import jakarta.validation.Valid;

@Controller

public class PracEmployeeController {
   @Autowired
    private PracEmployeeRepository pracEmployeeRepository;

    

    @GetMapping("/employee/form")
    public String showForm(Model model) {
        model.addAttribute("pracEmployee", new PracEmployee());
        return "employeeForm";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@Valid PracEmployee pracEmployee, BindingResult result) {
        if (result.hasErrors()) {
            return "employeeForm";
        }
        pracEmployeeRepository.save(pracEmployee);
        return "redirect:/employee/form";
    }
}