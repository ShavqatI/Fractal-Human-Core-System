package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.usecase.CandidateUseCaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;
    private final CandidateUseCaseService candidateUseCaseService;

    @PostMapping
    public ResponseEntity<CandidateResponse> create(@RequestBody @Valid CandidateRequest dto) {
        return new ResponseEntity<>(candidateService.toDTO(candidateService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CandidateResponse>> getAll() {
        return ResponseEntity.ok(candidateService.getAll().stream().map(candidateService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.toDTO(candidateService.getById(id)));
    }

    @GetMapping("/compact")
    public ResponseEntity<List<CandidateCompactResponse>> getAllCompact() {
        return ResponseEntity.ok(candidateService.getAll().stream().map(candidateService::toCompactDTO).collect(Collectors.toList()));
    }

    @GetMapping("/compact/{id}")
    public ResponseEntity<CandidateCompactResponse> getByIdCompact(@PathVariable Long id) {
        return ResponseEntity.ok(candidateService.toCompactDTO(candidateService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateResponse> update(@PathVariable Long id, @RequestBody @Valid CandidateRequest dto) {
        return ResponseEntity.ok(candidateService.toDTO(candidateService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        candidateService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/hire/{id}")
    public ResponseEntity<Void> hire(@PathVariable Long id) {
        candidateUseCaseService.hire(id);
        return ResponseEntity.noContent().build();

    }

}
