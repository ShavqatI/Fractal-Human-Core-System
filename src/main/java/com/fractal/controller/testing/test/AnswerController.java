package com.fractal.controller.testing.test;


import com.fractal.domain.testing.question.answer.AnswerService;
import com.fractal.domain.testing.question.answer.dto.AnswerRequest;
import com.fractal.domain.testing.question.answer.dto.AnswerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test/question/{questionId}/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping()
    public ResponseEntity<AnswerResponse> create(@PathVariable Long questionId, @RequestBody @Valid AnswerRequest dto) {
        return new ResponseEntity<>(answerService.toDTO(answerService.create(questionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<AnswerResponse>> getAll(@PathVariable Long questionId) {
        return ResponseEntity.ok(answerService.getAllByQuestionId(questionId).stream().map(answerService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponse> getById(@PathVariable Long questionId, @PathVariable Long id) {
        return ResponseEntity.ok(answerService.toDTO(answerService.getById(questionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerResponse> update(@PathVariable Long questionId, @PathVariable Long id, @RequestBody @Valid AnswerRequest dto) {
        return ResponseEntity.ok(answerService.toDTO(answerService.update(questionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long questionId, @PathVariable Long id) {
        answerService.delete(questionId,id);
        return ResponseEntity.noContent().build();
    }


}
