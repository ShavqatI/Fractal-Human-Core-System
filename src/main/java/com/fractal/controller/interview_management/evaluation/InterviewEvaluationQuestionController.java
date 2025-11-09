package com.fractal.controller.interview_management.evaluation;


import com.fractal.domain.interview.evaluation.section.question.InterviewEvaluationQuestionService;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionRequest;
import com.fractal.domain.interview.evaluation.section.question.dto.InterviewEvaluationQuestionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/interview-management/interview-evaluation/section/{sectionId}/question")
@RequiredArgsConstructor
public class InterviewEvaluationQuestionController {

    private final InterviewEvaluationQuestionService questionService;

    @PostMapping()
    public ResponseEntity<InterviewEvaluationQuestionResponse> create(@PathVariable Long sectionId, @RequestBody @Valid InterviewEvaluationQuestionRequest dto) {
        return new ResponseEntity<>(questionService.toDTO(questionService.create(sectionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewEvaluationQuestionResponse>> getAll(@PathVariable Long sectionId) {
        return ResponseEntity.ok(questionService.getAllBySectionId(sectionId).stream().map(questionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationQuestionResponse> getById(@PathVariable Long sectionId, @PathVariable Long id) {
        return ResponseEntity.ok(questionService.toDTO(questionService.getById(sectionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationQuestionResponse> update(@PathVariable Long sectionId, @PathVariable Long id, @RequestBody @Valid InterviewEvaluationQuestionRequest dto) {
        return ResponseEntity.ok(questionService.toDTO(questionService.update(sectionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sectionId, @PathVariable Long id) {
        questionService.delete(sectionId,id);
        return ResponseEntity.noContent().build();
    }


}
