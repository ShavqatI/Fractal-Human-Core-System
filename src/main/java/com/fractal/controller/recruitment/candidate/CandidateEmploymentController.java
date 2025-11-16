package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmploymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/employment")
@RequiredArgsConstructor
public class CandidateEmploymentController {

    private final CandidateEmploymentService employmentService;

    @PostMapping()
    public ResponseEntity<EmploymentResponse> create(@PathVariable Long candidateId, @RequestBody @Valid ExternalEmploymentRequest dto) {
        return new ResponseEntity<>(employmentService.toDTO(employmentService.create(candidateId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(employmentService.getAllByCandidateId(candidateId).stream().map(employmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentResponse> getById(@PathVariable Long candidateId, @PathVariable Long id) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.getById(candidateId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid ExternalEmploymentRequest dto) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.update(candidateId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        employmentService.delete(candidateId, id);
        return ResponseEntity.noContent().build();
    }

}
