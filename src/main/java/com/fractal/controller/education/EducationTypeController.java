package com.fractal.controller.education;


import com.fractal.domain.education.type.EducationTypeService;
import com.fractal.domain.education.type.dto.EducationTypeRequest;
import com.fractal.domain.education.type.dto.EducationTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/education/type")
@RequiredArgsConstructor
public class EducationTypeController {

    private final EducationTypeService educationTypeService;

    @PostMapping
    public ResponseEntity<EducationTypeResponse> create(@RequestBody @Valid EducationTypeRequest dto) {
        return new ResponseEntity<>(educationTypeService.toDTO(educationTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EducationTypeResponse>> getAll() {
        return ResponseEntity.ok(educationTypeService.getAll().stream().map(educationTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(educationTypeService.toDTO(educationTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<EducationTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(educationTypeService.toDTO(educationTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationTypeResponse> update(@PathVariable Long id, @RequestBody @Valid EducationTypeRequest dto) {
        return ResponseEntity.ok(educationTypeService.toDTO(educationTypeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        educationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
