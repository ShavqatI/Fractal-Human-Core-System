package com.fractal.controller.profile.employee;


import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.profile.employee.employment.ProfileEmploymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/employment")
@RequiredArgsConstructor
public class ProfileEmploymentController {

    private final ProfileEmploymentService employmentService;
    @GetMapping
    public ResponseEntity<List<EmploymentResponse>> getAll() {
        return ResponseEntity.ok(employmentService.getAll().stream().map(employmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.getById(id)));
    }


}
