package com.fractal.controller.employee_management.employee;


import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.employee_management.citizenship.EmployeeCitizenshipService;
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
    public ResponseEntity<CitizenshipResponse> create(@PathVariable Long employeeId, @RequestBody @Valid CitizenshipRequest dto) {
        return new ResponseEntity<>(employeeCitizenshipService.toDTO(employeeCitizenshipService.create(employeeId,dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CitizenshipResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeCitizenshipService.getAllByEmployeeId(employeeId).stream().map(employeeCitizenshipService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(employeeCitizenshipService.toDTO(employeeCitizenshipService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid CitizenshipRequest dto) {
        return ResponseEntity.ok(employeeCitizenshipService.toDTO(employeeCitizenshipService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        employeeCitizenshipService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }


}
