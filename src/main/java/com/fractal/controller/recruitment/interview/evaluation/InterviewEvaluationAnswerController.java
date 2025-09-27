package com.fractal.controller.recruitment.interview.evaluation;


import com.fractal.domain.interview.evaluation.section.question.answer.InterviewEvaluationAnswerService;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerRequest;
import com.fractal.domain.interview.evaluation.section.question.answer.dto.InterviewEvaluationAnswerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/evaluation/section/question/{questionId}/answer")
@RequiredArgsConstructor
public class InterviewEvaluationAnswerController {

    private final InterviewEvaluationAnswerService answerService;

    @PostMapping()
    public ResponseEntity<InterviewEvaluationAnswerResponse> create(@PathVariable Long questionId, @RequestBody @Valid InterviewEvaluationAnswerRequest dto) {
        return new ResponseEntity<>(answerService.toDTO(answerService.create(questionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewEvaluationAnswerResponse>> getAll(@PathVariable Long questionId) {
        return ResponseEntity.ok(answerService.getAllByQuestionId(questionId).stream().map(answerService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationAnswerResponse> getById(@PathVariable Long questionId, @PathVariable Long id) {
        return ResponseEntity.ok(answerService.toDTO(answerService.getById(questionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationAnswerResponse> update(@PathVariable Long questionId, @PathVariable Long id, @RequestBody @Valid InterviewEvaluationAnswerRequest dto) {
        return ResponseEntity.ok(answerService.toDTO(answerService.update(questionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long questionId, @PathVariable Long id) {
        answerService.delete(questionId,id);
        return ResponseEntity.noContent().build();
    }


}
