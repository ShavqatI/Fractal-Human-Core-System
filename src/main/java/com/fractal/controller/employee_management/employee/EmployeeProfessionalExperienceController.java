package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.professional_experience.EmployeeProfessionalExperienceService;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceRequest;
import com.fractal.domain.employee_management.professional_experience.dto.EmployeeProfessionalExperienceResponse;
import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperienceService;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/professional-experience")
@RequiredArgsConstructor
public class EmployeeProfessionalExperienceController {

    private final EmployeeProfessionalExperienceService professionalExperienceService;

    @PostMapping()
    public ResponseEntity<EmployeeProfessionalExperienceResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EmployeeProfessionalExperienceRequest dto) {
        return new ResponseEntity<>(professionalExperienceService.toDTO(professionalExperienceService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeProfessionalExperienceResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(professionalExperienceService.getAllByCandidateId(employeeId).stream().map(professionalExperienceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeProfessionalExperienceResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeProfessionalExperienceResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EmployeeProfessionalExperienceRequest dto) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        professionalExperienceService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
