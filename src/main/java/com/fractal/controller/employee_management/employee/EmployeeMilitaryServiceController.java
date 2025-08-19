package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.military_service.EmployeeMilitaryServiceService;
import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/military-service")
@RequiredArgsConstructor
public class EmployeeMilitaryServiceController {

    private final EmployeeMilitaryServiceService militaryServiceService;

    @PostMapping()
    public ResponseEntity<MilitaryServiceResponse> create(@PathVariable Long employeeId, @RequestBody @Valid MilitaryServiceRequest dto) {
        return new ResponseEntity<>(militaryServiceService.toDTO(militaryServiceService.create(employeeId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MilitaryServiceResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(militaryServiceService.getAllByEmployeeId(employeeId).stream().map(militaryServiceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> getById(@PathVariable Long employeeId,@PathVariable Long id) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.getById(employeeId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid MilitaryServiceRequest dto) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.update(employeeId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        militaryServiceService.delete(employeeId,id);
        return ResponseEntity.noContent().build();
    }

}
