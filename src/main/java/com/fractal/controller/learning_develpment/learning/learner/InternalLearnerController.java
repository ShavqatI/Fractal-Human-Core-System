package com.fractal.controller.learning_develpment.learning.learner;

import com.fractal.domain.learning_develpment.learning.learner.internal.InternalLearnerService;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerCompactResponse;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerRequest;
import com.fractal.domain.learning_develpment.learning.learner.internal.dto.InternalLearnerResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/learner/internal")
@RequiredArgsConstructor
public class InternalLearnerController {

    private final InternalLearnerService learnerService;

    @PostMapping
    public ResponseEntity<InternalLearnerResponse> create(@RequestBody @Valid InternalLearnerRequest dto) {
        return new ResponseEntity<>(learnerService.toDTO(learnerService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InternalLearnerResponse>> getAll() {
        return ResponseEntity.ok(learnerService.getAll().stream().map(learnerService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternalLearnerResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(learnerService.toDTO(learnerService.getById(id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<InternalLearnerCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(learnerService.getAll().stream().map(learnerService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<InternalLearnerCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(learnerService.toCompactDTO(learnerService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternalLearnerResponse> update(@PathVariable Long id, @RequestBody @Valid InternalLearnerRequest dto) {
        return ResponseEntity.ok(learnerService.toDTO(learnerService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        learnerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
