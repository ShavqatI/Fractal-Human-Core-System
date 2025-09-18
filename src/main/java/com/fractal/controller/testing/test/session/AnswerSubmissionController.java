package com.fractal.controller.testing.test.session;


import com.fractal.domain.testing.test.session.answer.AnswerSubmissionService;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionRequest;
import com.fractal.domain.testing.test.session.answer.dto.AnswerSubmissionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test-session/{testSessionId}/answer-submission")
@RequiredArgsConstructor
public class AnswerSubmissionController {

    private final AnswerSubmissionService submissionService;

    @PostMapping()
    public ResponseEntity<AnswerSubmissionResponse> create(@PathVariable Long testSessionId, @RequestBody @Valid AnswerSubmissionRequest dto) {
        return new ResponseEntity<>(submissionService.toDTO(submissionService.create(testSessionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AnswerSubmissionResponse>> getAll(@PathVariable Long testSessionId) {
        return ResponseEntity.ok(submissionService.getAllBySessionId(testSessionId).stream().map(submissionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnswerSubmissionResponse> getById(@PathVariable Long testSessionId, @PathVariable Long id) {
        return ResponseEntity.ok(submissionService.toDTO(submissionService.getById(testSessionId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AnswerSubmissionResponse> update(@PathVariable Long testSessionId, @PathVariable Long id, @RequestBody @Valid AnswerSubmissionRequest dto) {
        return ResponseEntity.ok(submissionService.toDTO(submissionService.update(testSessionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long testSessionId, @PathVariable Long id) {
        submissionService.delete(testSessionId,id);
        return ResponseEntity.noContent().build();
    }


}
