package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.enrollment.LearningSessionEnrollmentService;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentRequest;
import com.fractal.domain.learning_develpment.learning.session.enrollment.dto.LearningSessionEnrollmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/enrollment")
@RequiredArgsConstructor
public class LearningSessionEnrollmentController {

    private final LearningSessionEnrollmentService enrollmentService;

    @PostMapping()
    public ResponseEntity<LearningSessionEnrollmentResponse> create(@PathVariable Long sessionId, @RequestBody @Valid LearningSessionEnrollmentRequest dto) {
        return new ResponseEntity<>(enrollmentService.toDTO(enrollmentService.create(sessionId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LearningSessionEnrollmentResponse>> getAll(@PathVariable Long sessionId) {
        return ResponseEntity.ok(enrollmentService.getAllByLearningSessionId(sessionId).stream().map(enrollmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningSessionEnrollmentResponse> getById(@PathVariable Long sessionId, @PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.toDTO(enrollmentService.getById(sessionId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningSessionEnrollmentResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @RequestBody @Valid LearningSessionEnrollmentRequest dto) {
        return ResponseEntity.ok(enrollmentService.toDTO(enrollmentService.update(sessionId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        enrollmentService.delete(sessionId, id);
        return ResponseEntity.noContent().build();
    }


}
