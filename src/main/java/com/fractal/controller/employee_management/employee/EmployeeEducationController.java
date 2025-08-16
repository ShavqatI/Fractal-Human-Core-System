package com.fractal.controller.employee_management.employee;


import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employee_management.education.EmployeeEducationService;
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

    private final EmployeeEducationService employeeEducationService;

    @PostMapping()
    public ResponseEntity<EducationResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EducationRequest dto) {
        return new ResponseEntity<>(employeeEducationService.toDTO(employeeEducationService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeEducationService.getAllByEmployeeId(employeeId).stream().map(employeeEducationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(employeeEducationService.toDTO(employeeEducationService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EducationResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EducationRequest dto) {
        return ResponseEntity.ok(employeeEducationService.toDTO(employeeEducationService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employeeEducationService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
