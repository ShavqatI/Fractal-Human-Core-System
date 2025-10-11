package com.fractal.controller.employee_management.employee;


import com.fractal.domain.employee_management.employee.resource.type.EmployeeResourceTypeService;
import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeRequest;
import com.fractal.domain.employee_management.employee.resource.type.dto.EmployeeResourceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/resource-type")
@RequiredArgsConstructor
public class EmployeeResourceTypeController {

    private final EmployeeResourceTypeService resourceTypeService;
    @PostMapping
    public ResponseEntity<EmployeeResourceTypeResponse> create(@RequestBody @Valid EmployeeResourceTypeRequest dto) {
        return new ResponseEntity<>(resourceTypeService.toDTO(resourceTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResourceTypeResponse>> getAll() {
        return ResponseEntity.ok(resourceTypeService.getAll().stream().map(resourceTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResourceTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<EmployeeResourceTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResourceTypeResponse> update(@PathVariable Long id, @RequestBody @Valid EmployeeResourceTypeRequest dto) {
      return  ResponseEntity.ok(resourceTypeService.toDTO(resourceTypeService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        resourceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
