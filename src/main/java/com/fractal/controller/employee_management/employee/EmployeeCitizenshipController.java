package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.citizenship.EmployeeCitizenshipService;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipRequest;
import com.fractal.domain.employee_management.citizenship.dto.EmployeeCitizenshipResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/citizenship")
@RequiredArgsConstructor
public class EmployeeCitizenshipController {

    private final EmployeeCitizenshipService employeeCitizenshipService;

    @PostMapping()
    public ResponseEntity<EmployeeCitizenshipResponse> create(@PathVariable Long employeeId, @RequestBody @Valid EmployeeCitizenshipRequest dto) {
        return new ResponseEntity<>(employeeCitizenshipService.toDTO(employeeCitizenshipService.create(employeeId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeCitizenshipResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeCitizenshipService.getAllByEmployeeId(employeeId).stream().map(employeeCitizenshipService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeCitizenshipResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(employeeCitizenshipService.toDTO(employeeCitizenshipService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeCitizenshipResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid EmployeeCitizenshipRequest dto) {
        return ResponseEntity.ok(employeeCitizenshipService.toDTO(employeeCitizenshipService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employeeCitizenshipService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
