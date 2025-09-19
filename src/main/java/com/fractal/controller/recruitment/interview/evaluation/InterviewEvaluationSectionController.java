package com.fractal.controller.recruitment.interview.evaluation;


import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSectionService;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionRequest;
import com.fractal.domain.recruitment.interview.evaluation.section.dto.InterviewEvaluationSectionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/evaluation/{evaluationId}/section")
@RequiredArgsConstructor
public class InterviewEvaluationSectionController {

    private final InterviewEvaluationSectionService sectionService;

    @PostMapping()
    public ResponseEntity<InterviewEvaluationSectionResponse> create(@PathVariable Long evaluationId, @RequestBody @Valid InterviewEvaluationSectionRequest dto) {
        return new ResponseEntity<>(sectionService.toDTO(sectionService.create(evaluationId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewEvaluationSectionResponse>> getAll(@PathVariable Long evaluationId) {
        return ResponseEntity.ok(sectionService.getAllByInterviewEvaluationId(evaluationId).stream().map(sectionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSectionResponse> getById(@PathVariable Long evaluationId, @PathVariable Long id) {
        return ResponseEntity.ok(sectionService.toDTO(sectionService.getById(evaluationId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSectionResponse> update(@PathVariable Long evaluationId, @PathVariable Long id, @RequestBody @Valid InterviewEvaluationSectionRequest dto) {
        return ResponseEntity.ok(sectionService.toDTO(sectionService.update(evaluationId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long evaluationId, @PathVariable Long id) {
        sectionService.delete(evaluationId,id);
        return ResponseEntity.noContent().build();
    }


}
