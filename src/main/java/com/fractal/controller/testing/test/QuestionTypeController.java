package com.fractal.controller.testing.test;


import com.fractal.domain.testing.question.type.QuestionTypeService;
import com.fractal.domain.testing.question.type.dto.QuestionTypeRequest;
import com.fractal.domain.testing.question.type.dto.QuestionTypeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/testing/test/question-type")
@RequiredArgsConstructor
public class QuestionTypeController {

    private final QuestionTypeService questionTypeService;

    @PostMapping
    public ResponseEntity<QuestionTypeResponse> create(@RequestBody @Valid QuestionTypeRequest dto) {
        return new ResponseEntity<>(questionTypeService.toDTO(questionTypeService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionTypeResponse>> getAll() {
        return ResponseEntity.ok(questionTypeService.getAll().stream().map(questionTypeService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionTypeResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(questionTypeService.toDTO(questionTypeService.getById(id)));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<QuestionTypeResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(questionTypeService.toDTO(questionTypeService.getByCode(code)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionTypeResponse> update(@PathVariable Long id, @RequestBody @Valid QuestionTypeRequest dto) {
        return ResponseEntity.ok(questionTypeService.toDTO(questionTypeService.update(id, dto)));


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        questionTypeService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
