package com.fractal.controller.profile.candidate;


import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.profile.candidate.education.CandidateProfileEducationService;
import com.fractal.domain.recruitment.candidate.education.CandidateEducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/education")
@RequiredArgsConstructor
public class CandidateProfileEducationController {

    private final CandidateProfileEducationService educationService;

    @PostMapping()
    public ResponseEntity<EducationResponse> create(@RequestBody @Valid EducationRequest dto) {
        return new ResponseEntity<>(educationService.toDTO(educationService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll() {
        return ResponseEntity.ok(educationService.getAll().stream().map(educationService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.toDTO(educationService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationResponse> update(@PathVariable Long id, @RequestBody @Valid EducationRequest dto) {
        return ResponseEntity.ok(educationService.toDTO(educationService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
