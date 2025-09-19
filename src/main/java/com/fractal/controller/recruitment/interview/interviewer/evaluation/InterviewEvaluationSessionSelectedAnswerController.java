package com.fractal.controller.recruitment.interview.interviewer.evaluation;


import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswerService;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.dto.InterviewEvaluationSessionSelectedAnswerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/interviewer/evaluation-session/answer-submission/{answerSubmissionId}/selected-answer")
@RequiredArgsConstructor
public class InterviewEvaluationSessionSelectedAnswerController {

    private final InterviewEvaluationSessionSelectedAnswerService selectedAnswerService;

    @PostMapping()
    public ResponseEntity<InterviewEvaluationSessionSelectedAnswerResponse> create(@PathVariable Long answerSubmissionId, @RequestBody @Valid InterviewEvaluationSessionSelectedAnswerRequest dto) {
        return new ResponseEntity<>(selectedAnswerService.toDTO(selectedAnswerService.create(answerSubmissionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewEvaluationSessionSelectedAnswerResponse>> getAll(@PathVariable Long answerSubmissionId) {
        return ResponseEntity.ok(selectedAnswerService.getAllByInterviewEvaluationSessionAnswerSubmissionId(answerSubmissionId).stream().map(selectedAnswerService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSessionSelectedAnswerResponse> getById(@PathVariable Long answerSubmissionId, @PathVariable Long id) {
        return ResponseEntity.ok(selectedAnswerService.toDTO(selectedAnswerService.getById(answerSubmissionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSessionSelectedAnswerResponse> update(@PathVariable Long answerSubmissionId, @PathVariable Long id, @RequestBody @Valid InterviewEvaluationSessionSelectedAnswerRequest dto) {
        return ResponseEntity.ok(selectedAnswerService.toDTO(selectedAnswerService.update(answerSubmissionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long answerSubmissionId, @PathVariable Long id) {
        selectedAnswerService.delete(answerSubmissionId,id);
        return ResponseEntity.noContent().build();
    }


}
