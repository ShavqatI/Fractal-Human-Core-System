package com.fractal.controller;

import com.fractal.domain.employee_management.employment.EmployeeEmployment;
import com.fractal.domain.employee_management.employment.EmployeeEmploymentService;
import com.fractal.domain.employee_management.employment.usecase.EmployeeEmploymentUseCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class HomeController {

    private final EmployeeEmploymentUseCaseService employmentService;

    @GetMapping
    public String index() {
       var l = employmentService.getHrHeadEmployeeName();
       return "size:" + l;
    }
}
