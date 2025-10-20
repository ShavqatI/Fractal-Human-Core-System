package com.fractal.controller.organization_management.grade;


import com.fractal.domain.organization_management.grade.method.type.GradingEvaluationTypeService;
import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeRequest;
import com.fractal.domain.organization_management.grade.method.type.dto.GradingEvaluationTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/organization-management/grade-management/evaluation-type")
@RequiredArgsConstructor
public class GradingEvaluationTypeController {

    private final GradingEvaluationTypeService evaluationTypeService;
    @PostMapping
    public ResponseEntity<GradingEvaluationTypeResponse> create(@RequestBody @Valid GradingEvaluationTypeRequest dto) {
        return new ResponseEntity<>(evaluationTypeService.toDTO(evaluationTypeService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<GradingEvaluationTypeResponse>> getAll() {
        return ResponseEntity.ok(evaluationTypeService.getAll().stream().map(evaluationTypeService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GradingEvaluationTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationTypeService.toDTO(evaluationTypeService.getById(id)));
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<GradingEvaluationTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(evaluationTypeService.toDTO(evaluationTypeService.getByCode(code)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GradingEvaluationTypeResponse> update(@PathVariable Long id, @RequestBody @Valid GradingEvaluationTypeRequest dto) {
      return  ResponseEntity.ok(evaluationTypeService.toDTO(evaluationTypeService.update(id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        evaluationTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
