package com.fractal.controller.education;


import com.fractal.domain.education.grade_point_average.GradePointAverageService;
import com.fractal.domain.education.grade_point_average.dto.GradePointAverageRequest;
import com.fractal.domain.education.grade_point_average.dto.GradePointAverageResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/education/grade-point-average")
@RequiredArgsConstructor
public class GradePointAverageController {

    private final GradePointAverageService gradePointAverageService;

    @PostMapping
    public ResponseEntity<GradePointAverageResponse> create(@RequestBody @Valid GradePointAverageRequest dto) {
        return new ResponseEntity<>(gradePointAverageService.toDTO(gradePointAverageService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GradePointAverageResponse>> getAll() {
        return ResponseEntity.ok(gradePointAverageService.getAll().stream().map(gradePointAverageService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradePointAverageResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(gradePointAverageService.toDTO(gradePointAverageService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradePointAverageResponse> update(@PathVariable Long id, @RequestBody @Valid GradePointAverageRequest dto) {
        return ResponseEntity.ok(gradePointAverageService.toDTO(gradePointAverageService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        gradePointAverageService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
