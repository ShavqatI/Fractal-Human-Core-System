package com.fractal.controller.employee_management.employee.employment;


import com.fractal.domain.employee_management.employment.type.EmploymentTypeService;
import com.fractal.domain.employee_management.employment.type.dto.EmploymentTypeRequest;
import com.fractal.domain.employee_management.employment.type.dto.EmploymentTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employment/type")
@RequiredArgsConstructor
public class EmploymentTypeController {

    private final EmploymentTypeService employmentTypeService;
    @PostMapping
    public ResponseEntity<EmploymentTypeResponse> create(@RequestBody @Valid EmploymentTypeRequest dto) {
        return new ResponseEntity<>(employmentTypeService.toDTO(employmentTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmploymentTypeResponse>> getAll() {
        return ResponseEntity.ok(employmentTypeService.getAll().stream().map(employmentTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmploymentTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employmentTypeService.toDTO(employmentTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<EmploymentTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(employmentTypeService.toDTO(employmentTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmploymentTypeResponse> update(@PathVariable Long id, @RequestBody @Valid EmploymentTypeRequest dto) {
      return  ResponseEntity.ok(employmentTypeService.toDTO(employmentTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employmentTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
