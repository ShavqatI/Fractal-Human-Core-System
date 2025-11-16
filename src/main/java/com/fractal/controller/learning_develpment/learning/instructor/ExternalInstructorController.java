package com.fractal.controller.learning_develpment.learning.instructor;

import com.fractal.domain.learning_develpment.learning.instructor.external.ExternalInstructorService;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorCompactResponse;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorRequest;
import com.fractal.domain.learning_develpment.learning.instructor.external.dto.ExternalInstructorResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/learning-development/learning/instructor/external")
@RequiredArgsConstructor
public class ExternalInstructorController {

    private final ExternalInstructorService instructorService;

    @PostMapping
    public ResponseEntity<ExternalInstructorResponse> create(@RequestBody @Valid ExternalInstructorRequest dto) {
        return new ResponseEntity<>(instructorService.toDTO(instructorService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExternalInstructorResponse>> getAll() {
        return ResponseEntity.ok(instructorService.getAll().stream().map(instructorService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExternalInstructorResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.toDTO(instructorService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<ExternalInstructorCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(instructorService.getAll().stream().map(instructorService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<ExternalInstructorCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.toCompactDTO(instructorService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExternalInstructorResponse> update(@PathVariable Long id, @RequestBody @Valid ExternalInstructorRequest dto) {
        return ResponseEntity.ok(instructorService.toDTO(instructorService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instructorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
