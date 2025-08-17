package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.work_experience.EmployeeWorkExperienceService;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.recruitment.candidate.work_experience.CandidateWorkExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/work-experience")
@RequiredArgsConstructor
public class EmployeeWorkExperienceController {

    private final EmployeeWorkExperienceService workExperienceService;

    @PostMapping()
    public ResponseEntity<WorkExperienceResponse> create(@PathVariable Long employeeId, @RequestBody @Valid WorkExperienceRequest dto) {
        return new ResponseEntity<>(workExperienceService.toDTO(workExperienceService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<WorkExperienceResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(workExperienceService.getAllByEmployeeId(employeeId).stream().map(workExperienceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkExperienceResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(workExperienceService.toDTO(workExperienceService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<WorkExperienceResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid WorkExperienceRequest dto) {
        return ResponseEntity.ok(workExperienceService.toDTO(workExperienceService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        workExperienceService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
