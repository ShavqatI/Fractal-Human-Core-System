package com.fractal.controller.learning_develpment.learning.session;


import com.fractal.domain.learning_develpment.learning.session.instructor.InstructorAssignmentService;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentRequest;
import com.fractal.domain.learning_develpment.learning.session.instructor.dto.InstructorAssignmentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/session/{sessionId}/instructor-assignment")
@RequiredArgsConstructor
public class InstructorAssignmentController {

    private final InstructorAssignmentService instructorAssignmentService;

    @PostMapping()
    public ResponseEntity<InstructorAssignmentResponse> create(@PathVariable Long sessionId, @RequestBody @Valid InstructorAssignmentRequest dto) {
        return new ResponseEntity<>(instructorAssignmentService.toDTO(instructorAssignmentService.create(sessionId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<InstructorAssignmentResponse>> getAll(@PathVariable Long sessionId) {
        return ResponseEntity.ok(instructorAssignmentService.getAllByLearningSessionId(sessionId).stream().map(instructorAssignmentService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<InstructorAssignmentResponse> getById(@PathVariable Long sessionId, @PathVariable Long id) {
        return ResponseEntity.ok(instructorAssignmentService.toDTO(instructorAssignmentService.getById(sessionId,id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstructorAssignmentResponse> update(@PathVariable Long sessionId, @PathVariable Long id, @RequestBody @Valid InstructorAssignmentRequest dto) {
        return ResponseEntity.ok(instructorAssignmentService.toDTO(instructorAssignmentService.update(sessionId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long sessionId, @PathVariable Long id) {
        instructorAssignmentService.delete(sessionId,id);
        return ResponseEntity.noContent().build();
    }


}
