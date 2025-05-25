package com.fractal.controller.employee_management;


import com.fractal.domain.employee_management.performance.type.PerformanceTypeService;
import com.fractal.domain.employee_management.performance.type.dto.PerformanceTypeRequest;
import com.fractal.domain.employee_management.performance.type.dto.PerformanceTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/performance-type")
@RequiredArgsConstructor
public class PerformanceTypeController {

    private final PerformanceTypeService performanceTypeService;
    @PostMapping
    public ResponseEntity<PerformanceTypeResponse> create(@RequestBody @Valid PerformanceTypeRequest dto) {
        return new ResponseEntity<>(performanceTypeService.toDTO(performanceTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<PerformanceTypeResponse>> getAll() {
        return ResponseEntity.ok(performanceTypeService.getAll().stream().map(performanceTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PerformanceTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(performanceTypeService.toDTO(performanceTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<PerformanceTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(performanceTypeService.toDTO(performanceTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PerformanceTypeResponse> update(@PathVariable Long id, @RequestBody @Valid PerformanceTypeRequest dto) {
      return  ResponseEntity.ok(performanceTypeService.toDTO(performanceTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        performanceTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
