package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.recruitment.candidate.education.CandidateEducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/education")
@RequiredArgsConstructor
public class CandidateEducationController {

    private final CandidateEducationService educationService;

    @PostMapping()
    public ResponseEntity<EducationResponse> create(@PathVariable Long candidateId, @RequestBody @Valid EducationRequest dto) {
        return new ResponseEntity<>(educationService.toDTO(educationService.create(candidateId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(educationService.getAllByCandidateId(candidateId).stream().map(educationService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> getById(@PathVariable Long candidateId,@PathVariable Long id) {
        return ResponseEntity.ok(educationService.toDTO(educationService.getById(candidateId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EducationResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid EducationRequest dto) {
        return ResponseEntity.ok(educationService.toDTO(educationService.update(candidateId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        educationService.delete(candidateId,id);
        return ResponseEntity.noContent().build();
    }


}
