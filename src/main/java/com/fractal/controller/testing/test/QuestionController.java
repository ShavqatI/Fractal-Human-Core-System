package com.fractal.controller.testing.test;


import com.fractal.domain.testing.question.QuestionService;
import com.fractal.domain.testing.question.dto.QuestionCompactResponse;
import com.fractal.domain.testing.question.dto.QuestionRequest;
import com.fractal.domain.testing.question.dto.QuestionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test/{testId}/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping()
    public ResponseEntity<QuestionResponse> create(@PathVariable Long testId, @RequestBody @Valid QuestionRequest dto) {
        return new ResponseEntity<>(questionService.toDTO(questionService.create(testId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<QuestionResponse>> getAll(@PathVariable Long testId) {
        return ResponseEntity.ok(questionService.getAllByTestId(testId).stream().map(questionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> getById(@PathVariable Long testId, @PathVariable Long id) {
        return ResponseEntity.ok(questionService.toDTO(questionService.getById(testId,id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<QuestionCompactResponse>> getAllCompact(@PathVariable Long testId) {
        return ResponseEntity.ok(questionService.getAllByTestId(testId).stream().map(questionService::toCompactDTO).collect(Collectors.toList()));
    }
    @GetMapping("/compact/{id}")
    public ResponseEntity<QuestionCompactResponse> getByIdCompact(@PathVariable Long testId, @PathVariable Long id) {
        return ResponseEntity.ok(questionService.toCompactDTO(questionService.getById(testId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionResponse> update(@PathVariable Long testId, @PathVariable Long id, @RequestBody @Valid QuestionRequest dto) {
        return ResponseEntity.ok(questionService.toDTO(questionService.update(testId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long testId, @PathVariable Long id) {
        questionService.delete(testId,id);
        return ResponseEntity.noContent().build();
    }


}
