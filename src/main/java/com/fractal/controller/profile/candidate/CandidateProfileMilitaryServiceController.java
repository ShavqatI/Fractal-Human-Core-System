package com.fractal.controller.profile.candidate;


import com.fractal.domain.military_service.dto.MilitaryServiceRequest;
import com.fractal.domain.military_service.dto.MilitaryServiceResponse;
import com.fractal.domain.profile.candidate.military_service.CandidateProfileMilitaryServiceService;
import com.fractal.domain.recruitment.candidate.military_service.CandidateMilitaryServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/military-service")
@RequiredArgsConstructor
public class CandidateProfileMilitaryServiceController {

    private final CandidateProfileMilitaryServiceService militaryServiceService;

    @PostMapping()
    public ResponseEntity<MilitaryServiceResponse> create(@RequestBody @Valid MilitaryServiceRequest dto) {
        return new ResponseEntity<>(militaryServiceService.toDTO(militaryServiceService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MilitaryServiceResponse>> getAll() {
        return ResponseEntity.ok(militaryServiceService.getAll().stream().map(militaryServiceService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilitaryServiceResponse> update(@PathVariable Long id, @RequestBody @Valid MilitaryServiceRequest dto) {
        return ResponseEntity.ok(militaryServiceService.toDTO(militaryServiceService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        militaryServiceService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
