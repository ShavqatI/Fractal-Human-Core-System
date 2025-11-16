package com.fractal.controller.learning_develpment.learning.instructor;

import com.fractal.domain.learning_develpment.learning.instructor.internal.InternalInstructorService;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.internal.dto.InternalInstructorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/instructor/internal")
@RequiredArgsConstructor
public class InternalInstructorController {

    private final InternalInstructorService instructorService;

    @PostMapping
    public ResponseEntity<InternalInstructorResponse> create(@RequestBody @Valid InternalInstructorRequest dto) {
        return new ResponseEntity<>(instructorService.toDTO(instructorService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InternalInstructorResponse>> getAll() {
        return ResponseEntity.ok(instructorService.getAll().stream().map(instructorService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternalInstructorResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.toDTO(instructorService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<InternalInstructorCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(instructorService.getAll().stream().map(instructorService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<InternalInstructorCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.toCompactDTO(instructorService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InternalInstructorResponse> update(@PathVariable Long id, @RequestBody @Valid InternalInstructorRequest dto) {
        return ResponseEntity.ok(instructorService.toDTO(instructorService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instructorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
