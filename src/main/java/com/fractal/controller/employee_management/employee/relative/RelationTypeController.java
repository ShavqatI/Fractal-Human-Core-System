package com.fractal.controller.employee_management.employee.relative;


import com.fractal.domain.employee_management.relative.type.RelationTypeService;
import com.fractal.domain.employee_management.relative.type.dto.RelationTypeRequest;
import com.fractal.domain.employee_management.relative.type.dto.RelationTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/relative/relation-type")
@RequiredArgsConstructor
public class RelationTypeController {

    private final RelationTypeService relationTypeService;
    @PostMapping
    public ResponseEntity<RelationTypeResponse> create(@RequestBody @Valid RelationTypeRequest dto) {
        return new ResponseEntity<>(relationTypeService.toDTO(relationTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<RelationTypeResponse>> getAll() {
        return ResponseEntity.ok(relationTypeService.getAll().stream().map(relationTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RelationTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(relationTypeService.toDTO(relationTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<RelationTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(relationTypeService.toDTO(relationTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RelationTypeResponse> update(@PathVariable Long id, @RequestBody @Valid RelationTypeRequest dto) {
      return  ResponseEntity.ok(relationTypeService.toDTO(relationTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        relationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
