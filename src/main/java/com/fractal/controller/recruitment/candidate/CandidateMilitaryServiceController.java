package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/{candidateId}/military-service")
@RequiredArgsConstructor
public class CandidateMilitaryServiceController {

    private final CandidateMilitaryServiceService militaryServiceService;

    @PostMapping()
    public ResponseEntity<MilitaryServiceResponse> create(@PathVariable Long candidateId, @RequestBody @Valid MilitaryServiceRequest dto) {
        return new ResponseEntity<>(militaryServiceService.toDTO(militaryServiceService.create(candidateId, dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MilitaryServiceResponse>> getAll(@PathVariable Long candidateId) {
        return ResponseEntity.ok(militaryServiceService.getAllByCandidateId(candidateId).stream().map(militaryServiceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> getById(@PathVariable Long candidateId, @PathVariable Long id) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.getById(candidateId, id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> update(@PathVariable Long candidateId, @PathVariable Long id, @RequestBody @Valid MilitaryServiceRequest dto) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.update(candidateId, id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long candidateId, @PathVariable Long id) {
        militaryServiceService.delete(candidateId, id);
        return ResponseEntity.noContent().build();
    }

}
