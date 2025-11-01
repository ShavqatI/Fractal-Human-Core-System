package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperienceService;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/professional-experience")
@RequiredArgsConstructor
public class CandidateProfessionalExperienceController {

    private final CandidateProfessionalExperienceService professionalExperienceService;

    @PostMapping()
    public ResponseEntity<CandidateProfessionalExperienceResponse> create(@PathVariable Long candidateId, @RequestBody @Valid CandidateProfessionalExperienceRequest dto) {
        return new ResponseEntity<>(professionalExperienceService.toDTO(professionalExperienceService.create(candidateId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<CandidateProfessionalExperienceResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(professionalExperienceService.getAllByCandidateId(candidateId).stream().map(professionalExperienceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CandidateProfessionalExperienceResponse> getById(@PathVariable Long candidateId,@PathVariable Long id) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.getById(candidateId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CandidateProfessionalExperienceResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid CandidateProfessionalExperienceRequest dto) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.update(candidateId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        professionalExperienceService.delete(candidateId,id);
        return ResponseEntity.noContent().build();
    }


}
