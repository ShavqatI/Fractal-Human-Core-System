package com.fractal.controller.employee_management.employee.education;


import com.fractal.domain.employee_management.education.EducationService;
import com.fractal.domain.employee_management.education.dto.EducationRequest;
import com.fractal.domain.employee_management.education.dto.EducationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/education")
@RequiredArgsConstructor
public class EmployeeEducationController {

    private final EducationService educationService;

    @PostMapping()
    public ResponseEntity<EducationResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EducationRequest dto) {
        return new ResponseEntity<>(educationService.toDTO(educationService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(educationService.getAllByEmployeeId(employeeId).stream().map(educationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(educationService.toDTO(educationService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EducationResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EducationRequest dto) {
        return ResponseEntity.ok(educationService.toDTO(educationService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        educationService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
