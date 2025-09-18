package com.fractal.controller.testing.test.session;


import com.fractal.domain.testing.test.session.answer.selected.SelectedAnswerService;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerRequest;
import com.fractal.domain.testing.test.session.answer.selected.dto.SelectedAnswerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test-session/answer-submission/{answerSubmissionId}/selected-answer")
@RequiredArgsConstructor
public class SelectedAnswerController {

    private final SelectedAnswerService selectedAnswerService;

    @PostMapping()
    public ResponseEntity<SelectedAnswerResponse> create(@PathVariable Long answerSubmissionId, @RequestBody @Valid SelectedAnswerRequest dto) {
        return new ResponseEntity<>(selectedAnswerService.toDTO(selectedAnswerService.create(answerSubmissionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SelectedAnswerResponse>> getAll(@PathVariable Long answerSubmissionId) {
        return ResponseEntity.ok(selectedAnswerService.getAllByAnswerSubmissionId(answerSubmissionId).stream().map(selectedAnswerService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SelectedAnswerResponse> getById(@PathVariable Long answerSubmissionId, @PathVariable Long id) {
        return ResponseEntity.ok(selectedAnswerService.toDTO(selectedAnswerService.getById(answerSubmissionId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SelectedAnswerResponse> update(@PathVariable Long answerSubmissionId, @PathVariable Long id, @RequestBody @Valid SelectedAnswerRequest dto) {
        return ResponseEntity.ok(selectedAnswerService.toDTO(selectedAnswerService.update(answerSubmissionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long answerSubmissionId, @PathVariable Long id) {
        selectedAnswerService.delete(answerSubmissionId,id);
        return ResponseEntity.noContent().build();
    }


}
