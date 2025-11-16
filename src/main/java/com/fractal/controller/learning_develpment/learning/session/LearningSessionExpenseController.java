package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.expense.LearningSessionExpenseService;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseRequest;
import com.fractal.domain.learning_develpment.learning.session.expense.dto.LearningSessionExpenseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/expense")
@RequiredArgsConstructor
public class LearningSessionExpenseController {

    private final LearningSessionExpenseService expenseService;

    @PostMapping()
    public ResponseEntity<LearningSessionExpenseResponse> create(@PathVariable Long sessionId, @RequestBody @Valid LearningSessionExpenseRequest dto) {
        return new ResponseEntity<>(expenseService.toDTO(expenseService.create(sessionId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningSessionExpenseResponse>> getAll(@PathVariable Long sessionId) {
        return ResponseEntity.ok(expenseService.getAllByLearningSessionId(sessionId).stream().map(expenseService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningSessionExpenseResponse> getById(@PathVariable Long sessionId, @PathVariable Long id) {
        return ResponseEntity.ok(expenseService.toDTO(expenseService.getById(sessionId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningSessionExpenseResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @RequestBody @Valid LearningSessionExpenseRequest dto) {
        return ResponseEntity.ok(expenseService.toDTO(expenseService.update(sessionId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        expenseService.delete(sessionId, id);
        return ResponseEntity.noContent().build();
    }


}
