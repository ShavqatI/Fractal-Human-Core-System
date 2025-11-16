package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenshipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/citizenship")
@RequiredArgsConstructor
public class CandidateCitizenshipController {

    private final CandidateCitizenshipService citizenshipService;

    @PostMapping()
    public ResponseEntity<CitizenshipResponse> create(@PathVariable Long candidateId, @RequestBody @Valid CitizenshipRequest dto) {
        return new ResponseEntity<>(citizenshipService.toDTO(citizenshipService.create(candidateId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CitizenshipResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(citizenshipService.getAllByCandidateId(candidateId).stream().map(citizenshipService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> getById(@PathVariable Long candidateId, @PathVariable Long id) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.getById(candidateId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid CitizenshipRequest dto) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.update(candidateId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        citizenshipService.delete(candidateId, id);
        return ResponseEntity.noContent().build();
    }


}
