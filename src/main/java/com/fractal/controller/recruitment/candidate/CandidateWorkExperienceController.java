package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.recruitment.candidate.work_experience.CandidateWorkExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/work-experience")
@RequiredArgsConstructor
public class CandidateWorkExperienceController {

    private final CandidateWorkExperienceService workExperienceService;

    @PostMapping()
    public ResponseEntity<WorkExperienceResponse> create(@PathVariable Long candidateId, @RequestBody @Valid WorkExperienceRequest dto) {
        return new ResponseEntity<>(workExperienceService.toDTO(workExperienceService.create(candidateId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<WorkExperienceResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(workExperienceService.getAllByCandidateId(candidateId).stream().map(workExperienceService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkExperienceResponse> getById(@PathVariable Long candidateId,@PathVariable Long id) {
        return ResponseEntity.ok(workExperienceService.toDTO(workExperienceService.getById(candidateId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<WorkExperienceResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid WorkExperienceRequest dto) {
        return ResponseEntity.ok(workExperienceService.toDTO(workExperienceService.update(candidateId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        workExperienceService.delete(candidateId,id);
        return ResponseEntity.noContent().build();
    }


}
