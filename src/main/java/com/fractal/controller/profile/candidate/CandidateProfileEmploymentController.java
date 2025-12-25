package com.fractal.controller.profile.candidate;


import com.fractal.domain.employment.dto.EmploymentResponse;
import com.fractal.domain.employment.external.dto.ExternalEmploymentRequest;
import com.fractal.domain.profile.candidate.employment.CandidateProfileEmploymentService;
import com.fractal.domain.recruitment.candidate.employment.CandidateEmploymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/employment")
@RequiredArgsConstructor
public class CandidateProfileEmploymentController {

    private final CandidateProfileEmploymentService employmentService;

    @PostMapping()
    public ResponseEntity<EmploymentResponse> create(@RequestBody @Valid ExternalEmploymentRequest dto) {
        return new ResponseEntity<>(employmentService.toDTO(employmentService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmploymentResponse>> getAll() {
        return ResponseEntity.ok(employmentService.getAll().stream().map(employmentService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentResponse> update(@PathVariable Long id, @RequestBody @Valid ExternalEmploymentRequest dto) {
        return ResponseEntity.ok(employmentService.toDTO(employmentService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
