package com.fractal.controller.organization_management.department;

import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.department.DepartmentDto;
import com.fractal.domain.organization_management.department.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organization_management/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody @Valid DepartmentDto dto) {
        return new ResponseEntity<>(departmentService.create(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<Department> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.getByCode(code));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody @Valid DepartmentDto dto) {
        return  ResponseEntity.ok(departmentService.update(id,dto));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
