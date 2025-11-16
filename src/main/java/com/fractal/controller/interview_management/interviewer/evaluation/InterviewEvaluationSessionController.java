package com.fractal.controller.interview_management.interviewer.evaluation;


import com.fractal.domain.interview.evaluation.session.InterviewEvaluationSessionService;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionRequest;
import com.fractal.domain.interview.evaluation.session.dto.InterviewEvaluationSessionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/interview/interviewer/{interviewerId}/evaluation-session")
@RequiredArgsConstructor
public class InterviewEvaluationSessionController {

    private final InterviewEvaluationSessionService sessionService;

    @PostMapping()
    public ResponseEntity<InterviewEvaluationSessionResponse> create(@PathVariable Long interviewerId, @RequestBody @Valid InterviewEvaluationSessionRequest dto) {
        return new ResponseEntity<>(sessionService.toDTO(sessionService.create(interviewerId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InterviewEvaluationSessionResponse>> getAll(@PathVariable Long interviewerId) {
        return ResponseEntity.ok(sessionService.getAllByInterviewerId(interviewerId).stream().map(sessionService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSessionResponse> getById(@PathVariable Long interviewerId, @PathVariable Long id) {
        return ResponseEntity.ok(sessionService.toDTO(sessionService.getById(interviewerId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewEvaluationSessionResponse> update(@PathVariable Long interviewerId, @PathVariable Long id, @RequestBody @Valid InterviewEvaluationSessionRequest dto) {
        return ResponseEntity.ok(sessionService.toDTO(sessionService.update(interviewerId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long interviewerId, @PathVariable Long id) {
        sessionService.delete(interviewerId, id);
        return ResponseEntity.noContent().build();
    }


}
