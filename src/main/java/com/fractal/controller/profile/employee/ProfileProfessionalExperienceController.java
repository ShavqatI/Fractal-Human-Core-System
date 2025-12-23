package com.fractal.controller.profile.employee;


import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;
import com.fractal.domain.profile.professional_experience.ProfileProfessionalExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/employee/professional-experience")
@RequiredArgsConstructor
public class ProfileProfessionalExperienceController {

    private final ProfileProfessionalExperienceService professionalExperienceService;
    @GetMapping
    public ResponseEntity<List<EmployeeProfessionalExperienceResponse>> getAll() {
        return ResponseEntity.ok(professionalExperienceService.getAll().stream().map(professionalExperienceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfessionalExperienceResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.getById(id)));
    }


}
