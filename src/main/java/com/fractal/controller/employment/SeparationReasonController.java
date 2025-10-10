/*
package com.fractal.controller.employment;


import com.fractal.domain.employment.work_experience.separation_reason.SeparationReasonService;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonRequest;
import com.fractal.domain.employment.work_experience.separation_reason.dto.SeparationReasonResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employment/work-experience/{workExperienceId}/separation-reason")
@RequiredArgsConstructor
public class SeparationReasonController {

    private final SeparationReasonService separationReasonService;

    @PostMapping()
    public ResponseEntity<SeparationReasonResponse> create(@PathVariable Long workExperienceId, @RequestBody @Valid SeparationReasonRequest dto) {
        return new ResponseEntity<>(separationReasonService.toDTO(separationReasonService.create(workExperienceId,dto)), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SeparationReasonResponse>> getAll(@PathVariable Long workExperienceId) {
        return ResponseEntity.ok(separationReasonService.getAllByWorkExperienceId(workExperienceId).stream().map(separationReasonService::toDTO).collect(Collectors.toList()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeparationReasonResponse> getById(@PathVariable Long workExperienceId, @PathVariable Long id) {
        return ResponseEntity.ok(separationReasonService.toDTO(separationReasonService.getById(workExperienceId,id)));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SeparationReasonResponse> update(@PathVariable Long workExperienceId, @PathVariable Long id, @RequestBody @Valid SeparationReasonRequest dto) {
        return ResponseEntity.ok(separationReasonService.toDTO(separationReasonService.update(workExperienceId,id, dto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long workExperienceId, @PathVariable Long id) {
        separationReasonService.delete(workExperienceId,id);
        return ResponseEntity.noContent().build();
    }


}
*/
