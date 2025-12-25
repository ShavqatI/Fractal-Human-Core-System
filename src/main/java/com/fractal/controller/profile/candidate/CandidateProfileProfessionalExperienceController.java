package com.fractal.controller.profile.candidate;


import com.fractal.domain.profile.candidate.professional_experience.CandidateProfileProfessionalExperienceService;
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
@RequestMapping("/api/v1/profile-management/candidate/professional-experience")
@RequiredArgsConstructor
public class CandidateProfileProfessionalExperienceController {

    private final CandidateProfileProfessionalExperienceService professionalExperienceService;

    @PostMapping()
    public ResponseEntity<CandidateProfessionalExperienceResponse> create(@RequestBody @Valid CandidateProfessionalExperienceRequest dto) {
        return new ResponseEntity<>(professionalExperienceService.toDTO(professionalExperienceService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CandidateProfessionalExperienceResponse>> getAll() {
        return ResponseEntity.ok(professionalExperienceService.getAll().stream().map(professionalExperienceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateProfessionalExperienceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CandidateProfessionalExperienceResponse> update(@PathVariable Long id, @RequestBody @Valid CandidateProfessionalExperienceRequest dto) {
        return ResponseEntity.ok(professionalExperienceService.toDTO(professionalExperienceService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professionalExperienceService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
