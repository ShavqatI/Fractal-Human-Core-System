package com.fractal.controller.employee_management.subordinate;


import com.fractal.domain.employee_management.subordinate.type.SubordinateTypeService;
import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeRequest;
import com.fractal.domain.employee_management.subordinate.type.dto.SubordinateTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/subordinate/type")
@RequiredArgsConstructor
public class SubordinateTypeController {

    private final SubordinateTypeService subordinateTypeService;

    @PostMapping
    public ResponseEntity<SubordinateTypeResponse> create(@RequestBody @Valid SubordinateTypeRequest dto) {
        return new ResponseEntity<>(subordinateTypeService.toDTO(subordinateTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SubordinateTypeResponse>> getAll() {
        return ResponseEntity.ok(subordinateTypeService.getAll().stream().map(subordinateTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubordinateTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(subordinateTypeService.toDTO(subordinateTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<SubordinateTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(subordinateTypeService.toDTO(subordinateTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubordinateTypeResponse> update(@PathVariable Long id, @RequestBody @Valid SubordinateTypeRequest dto) {
        return ResponseEntity.ok(subordinateTypeService.toDTO(subordinateTypeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subordinateTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
