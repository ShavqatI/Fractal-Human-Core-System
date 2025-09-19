package com.fractal.controller.recruitment.interview.interviewer.evaluation;


import com.fractal.domain.recruitment.interview.evaluation.session.answer.InterviewEvaluationSessionAnswerSubmissionService;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionRequest;
import com.fractal.domain.recruitment.interview.evaluation.session.answer.dto.InterviewEvaluationSessionAnswerSubmissionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/interviewer/evaluation-session/{evaluationSessionId}/answer-submission")
@RequiredArgsConstructor
public class InterviewEvaluationSessionAnswerSubmissionController {

    private final InterviewEvaluationSessionAnswerSubmissionService answerSubmissionService;

    @PostMapping()
    public ResponseEntity<InterviewEvaluationSessionAnswerSubmissionResponse> create(@PathVariable Long evaluationSessionId, @RequestBody @Valid InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        return new ResponseEntity<>(answerSubmissionService.toDTO(answerSubmissionService.create(evaluationSessionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InterviewEvaluationSessionAnswerSubmissionResponse>> getAll(@PathVariable Long evaluationSessionId) {
        return ResponseEntity.ok(answerSubmissionService.getAllByInterviewEvaluationSessionId(evaluationSessionId).stream().map(answerSubmissionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSessionAnswerSubmissionResponse> getById(@PathVariable Long evaluationSessionId, @PathVariable Long id) {
        return ResponseEntity.ok(answerSubmissionService.toDTO(answerSubmissionService.getById(evaluationSessionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSessionAnswerSubmissionResponse> update(@PathVariable Long evaluationSessionId, @PathVariable Long id, @RequestBody @Valid InterviewEvaluationSessionAnswerSubmissionRequest dto) {
        return ResponseEntity.ok(answerSubmissionService.toDTO(answerSubmissionService.update(evaluationSessionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long evaluationSessionId, @PathVariable Long id) {
        answerSubmissionService.delete(evaluationSessionId,id);
        return ResponseEntity.noContent().build();
    }


}
