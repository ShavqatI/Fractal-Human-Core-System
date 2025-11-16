package com.fractal.controller.organization_management.grade;

import com.fractal.domain.organization_management.grade.GradeService;
import com.fractal.domain.organization_management.grade.dto.GradeCompactResponse;
import com.fractal.domain.organization_management.grade.dto.GradeRequest;
import com.fractal.domain.organization_management.grade.dto.GradeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<GradeResponse> create(@RequestBody @Valid GradeRequest dto) {
        return new ResponseEntity<>(gradeService.toDTO(gradeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GradeResponse>> getAll() {
        return ResponseEntity.ok(gradeService.getAll().stream().map(gradeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<GradeCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(gradeService.getAll().stream().map(gradeService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gradeService.toDTO(gradeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<GradeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(gradeService.toDTO(gradeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeResponse> update(@PathVariable Long id, @RequestBody @Valid GradeRequest dto) {
        return ResponseEntity.ok(gradeService.toDTO(gradeService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gradeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
