package com.fractal.controller.integration.mapping;

import com.fractal.domain.integration.mapping.department.DepartmentMappingService;
import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingRequest;
import com.fractal.domain.integration.mapping.department.dto.DepartmentMappingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/integration/mapping/department")
@RequiredArgsConstructor
public class DepartmentMappingController {

    private final DepartmentMappingService departmentMappingService;


    @PostMapping
    public ResponseEntity<DepartmentMappingResponse> create(@RequestBody @Valid DepartmentMappingRequest dto) {
        return new ResponseEntity<>(departmentMappingService.toDTO(departmentMappingService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentMappingResponse>> getAll() {
        return ResponseEntity.ok(departmentMappingService.getAll().stream().map(departmentMappingService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentMappingResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentMappingService.toDTO(departmentMappingService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentMappingResponse> update(@PathVariable Long id, @RequestBody @Valid DepartmentMappingRequest dto) {
        return ResponseEntity.ok(departmentMappingService.toDTO(departmentMappingService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentMappingService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
