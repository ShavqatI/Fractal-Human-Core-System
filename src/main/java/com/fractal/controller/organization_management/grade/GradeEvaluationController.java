package com.fractal.controller.organization_management.grade;


import com.fractal.domain.organization_management.grade.evaluation.GradeEvaluationService;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationRequest;
import com.fractal.domain.organization_management.grade.method.dto.GradingEvaluationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/grade/{gradeId}/evaluation")
@RequiredArgsConstructor
public class GradeEvaluationController {

    private final GradeEvaluationService evaluationService;

    @PostMapping()
    public ResponseEntity<GradingEvaluationResponse> create(@PathVariable Long gradeId, @RequestBody @Valid GradingEvaluationRequest dto) {
        return new ResponseEntity<>(evaluationService.toDTO(evaluationService.create(gradeId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GradingEvaluationResponse>> getAll(@PathVariable Long gradeId) {
        return ResponseEntity.ok(evaluationService.getAllByGradeId(gradeId).stream().map(evaluationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradingEvaluationResponse> getById(@PathVariable Long gradeId, @PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.toDTO(evaluationService.getById(gradeId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GradingEvaluationResponse> update(@PathVariable Long gradeId, @PathVariable Long id, @RequestBody @Valid GradingEvaluationRequest dto) {
        return ResponseEntity.ok(evaluationService.toDTO(evaluationService.update(gradeId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long employeeId, @PathVariable Long id) {
        evaluationService.delete(employeeId, id);
        return ResponseEntity.noContent().build();
    }

}
