package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.LearningSessionService;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionCompactResponse;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionRequest;
import com.fractal.domain.learning_develpment.learning.session.dto.LearningSessionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/{learningId}/session")
@RequiredArgsConstructor
public class LearningSessionController {

    private final LearningSessionService sessionService;

    @PostMapping()
    public ResponseEntity<LearningSessionResponse> create(@PathVariable Long learningId, @RequestBody @Valid LearningSessionRequest dto) {
        return new ResponseEntity<>(sessionService.toDTO(sessionService.create(learningId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<LearningSessionResponse>> getAll(@PathVariable Long learningId) {
        return ResponseEntity.ok(sessionService.getAllByLearningId(learningId).stream().map(sessionService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<LearningSessionResponse> getById(@PathVariable Long learningId, @PathVariable Long id) {
        return ResponseEntity.ok(sessionService.toDTO(sessionService.getById(learningId,id)));
    }
    @GetMapping("/compact")
    public ResponseEntity<List<LearningSessionCompactResponse>> getAllCompact(@PathVariable Long learningId) {
        return ResponseEntity.ok(sessionService.getAllByLearningId(learningId).stream().map(sessionService::toCompactDTO).collect(Collectors.toList()));
    }
    @GetMapping("/compact/{id}")
    public ResponseEntity<LearningSessionCompactResponse> getByIdCompact(@PathVariable Long learningId, @PathVariable Long id) {
        return ResponseEntity.ok(sessionService.toCompactDTO(sessionService.getById(learningId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LearningSessionResponse> update(@PathVariable Long learningId, @PathVariable Long id, @RequestBody @Valid LearningSessionRequest dto) {
        return ResponseEntity.ok(sessionService.toDTO(sessionService.update(learningId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long learningId, @PathVariable Long id) {
        sessionService.delete(learningId,id);
        return ResponseEntity.noContent().build();
    }


}
