package com.fractal.controller.employee_management.employee.relative;


import com.fractal.domain.employee_management.relative.RelativeService;
import com.fractal.domain.employee_management.relative.dto.RelativeRequest;
import com.fractal.domain.employee_management.relative.dto.RelativeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/employee/{employeeId}/relative")
@RequiredArgsConstructor
public class EmployeeRelativeController {

    private final RelativeService relativeService;

    @PostMapping()
    public ResponseEntity<RelativeResponse> create(@PathVariable Long employeeId, @RequestBody @Valid RelativeRequest dto) {
        return new ResponseEntity<>(relativeService.toDTO(relativeService.create(employeeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RelativeResponse>> getAll(@PathVariable Long employeeId) {
        return ResponseEntity.ok(relativeService.getAllByEmployeeId(employeeId).stream().map(relativeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelativeResponse> getById(@PathVariable Long employeeId, @PathVariable Long id) {
        return ResponseEntity.ok(relativeService.toDTO(relativeService.getById(employeeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelativeResponse> update(@PathVariable Long employeeId, @PathVariable Long id, @RequestBody @Valid RelativeRequest dto) {
        return ResponseEntity.ok(relativeService.toDTO(relativeService.update(employeeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        relativeService.delete(employeeId, id);
        return ResponseEntity.noContent().build();
    }
}
