package com.fractal.controller.learning_develpment.learning.learner;

import com.fractal.domain.learning_develpment.learning.learner.external.ExternalLearnerService;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.external.dto.ExternalLearnerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/learner/external")
@RequiredArgsConstructor
public class ExternalLearnerController {

    private final ExternalLearnerService learnerService;

    @PostMapping
    public ResponseEntity<ExternalLearnerResponse> create(@RequestBody @Valid ExternalLearnerRequest dto) {
        return new ResponseEntity<>(learnerService.toDTO(learnerService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExternalLearnerResponse>> getAll() {
        return ResponseEntity.ok(learnerService.getAll().stream().map(learnerService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExternalLearnerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(learnerService.toDTO(learnerService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<ExternalLearnerCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(learnerService.getAll().stream().map(learnerService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<ExternalLearnerCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(learnerService.toCompactDTO(learnerService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExternalLearnerResponse> update(@PathVariable Long id, @RequestBody @Valid ExternalLearnerRequest dto) {
        return ResponseEntity.ok(learnerService.toDTO(learnerService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        learnerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
