package com.fractal.controller.interview_management.evaluation;


import com.fractal.domain.interview.evaluation.InterviewEvaluationService;
import com.fractal.domain.interview.evaluation.dto.InterviewEvaluationRequest;
import com.fractal.domain.interview.evaluation.dto.InterviewEvaluationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/interview-management/interview-evaluation")
@RequiredArgsConstructor
public class InterviewEvaluationController {

    private final InterviewEvaluationService evaluationService;
    @PostMapping
    public ResponseEntity<InterviewEvaluationResponse> create(@RequestBody @Valid InterviewEvaluationRequest dto) {
        return new ResponseEntity<>(evaluationService.toDTO(evaluationService.create(dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewEvaluationResponse>> getAll() {
        return ResponseEntity.ok(evaluationService.getAll().stream().map(evaluationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(evaluationService.toDTO(evaluationService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationResponse> update(@PathVariable Long id, @RequestBody @Valid InterviewEvaluationRequest dto) {
      return  ResponseEntity.ok(evaluationService.toDTO(evaluationService.update(id, dto)));


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        evaluationService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
