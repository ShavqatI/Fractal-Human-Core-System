package com.fractal.controller.employee_management;


import com.fractal.domain.employee_management.education.degree_type.DegreeTypeService;
import com.fractal.domain.employee_management.education.degree_type.dto.DegreeTypeRequest;
import com.fractal.domain.employee_management.education.degree_type.dto.DegreeTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee-management/degree-type")
@RequiredArgsConstructor
public class DegreeTypeController {

    private final DegreeTypeService degreeTypeService;
    @PostMapping
    public ResponseEntity<DegreeTypeResponse> create(@RequestBody @Valid DegreeTypeRequest dto) {
        return new ResponseEntity<>(degreeTypeService.toDTO(degreeTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DegreeTypeResponse>> getAll() {
        return ResponseEntity.ok(degreeTypeService.getAll().stream().map(degreeTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DegreeTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(degreeTypeService.toDTO(degreeTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<DegreeTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(degreeTypeService.toDTO(degreeTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<DegreeTypeResponse> update(@PathVariable Long id, @RequestBody @Valid DegreeTypeRequest dto) {
      return  ResponseEntity.ok(degreeTypeService.toDTO(degreeTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        degreeTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
