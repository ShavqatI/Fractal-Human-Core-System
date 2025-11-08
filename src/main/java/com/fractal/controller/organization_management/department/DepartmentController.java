package com.fractal.controller.organization_management.department;

import com.fractal.domain.organization_management.department.DepartmentService;
import com.fractal.domain.organization_management.department.dto.DepartmentCompactResponse;
import com.fractal.domain.organization_management.department.dto.DepartmentRequest;
import com.fractal.domain.organization_management.department.dto.DepartmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(@RequestBody @Valid DepartmentRequest dto) {
        return new ResponseEntity<>(departmentService.toDTO(departmentService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {
        return ResponseEntity.ok(departmentService.getAll().stream().map(departmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("top-level")
    public ResponseEntity<List<DepartmentResponse>> getAllToplevel() {
        return ResponseEntity.ok(departmentService.getAllTopLevel().stream().map(departmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.toDTO(departmentService.getById(id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<DepartmentCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(departmentService.getAll().stream().map(departmentService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<DepartmentCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.toCompactDTO(departmentService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DepartmentResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.toDTO(departmentService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(@PathVariable Long id, @RequestBody @Valid DepartmentRequest dto) {
        return ResponseEntity.ok(departmentService.toDTO(departmentService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
