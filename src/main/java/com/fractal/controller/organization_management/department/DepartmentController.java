package com.fractal.controller.organization_management.department;

import com.fractal.domain.organization_management.department.dto.DepartmentCreateDto;
import com.fractal.domain.organization_management.department.dto.DepartmentResponseDto;
import com.fractal.domain.organization_management.department.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization_management/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> create(@RequestBody @Valid DepartmentCreateDto dto) {
        return new ResponseEntity<>(departmentService.toDTO(departmentService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> getAll() {
        return ResponseEntity.ok(departmentService.getAll().stream().map(department -> departmentService.toDTO(department)).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.toDTO(departmentService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<DepartmentResponseDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.toDTO(departmentService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDto> update(@PathVariable Long id, @RequestBody @Valid DepartmentCreateDto dto) {
        return  ResponseEntity.ok(departmentService.toDTO(departmentService.update(id,dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
