package com.fractal.controller.organization_management.grade;

import com.fractal.domain.organization_management.grade.matrix.GradeMatrixService;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixRequest;
import com.fractal.domain.organization_management.grade.matrix.dto.GradeMatrixResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/grade/{gradeId}/matrix")
@RequiredArgsConstructor
public class GradeMatrixController {

    private final GradeMatrixService matrixService;

    @PostMapping()
    public ResponseEntity<GradeMatrixResponse> create(@PathVariable Long gradeId, @RequestBody @Valid GradeMatrixRequest dto) {
        return new ResponseEntity<>(matrixService.toDTO(matrixService.create(gradeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GradeMatrixResponse>> getAll(@PathVariable Long gradeId) {
        return ResponseEntity.ok(matrixService.getAllByGradeId(gradeId).stream().map(matrixService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeMatrixResponse> getById(@PathVariable Long gradeId, @PathVariable Long id) {
        return ResponseEntity.ok(matrixService.toDTO(matrixService.getById(gradeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradeMatrixResponse> update(@PathVariable Long gradeId, @PathVariable Long id, @RequestBody @Valid GradeMatrixRequest dto) {
        return ResponseEntity.ok(matrixService.toDTO(matrixService.update(gradeId, id, dto)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long gradeId, @PathVariable Long id) {
        matrixService.delete(gradeId, id);
        return ResponseEntity.noContent().build();
    }

}
