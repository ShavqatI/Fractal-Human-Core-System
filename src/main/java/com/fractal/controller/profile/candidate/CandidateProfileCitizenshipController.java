package com.fractal.controller.profile.candidate;


import com.fractal.domain.citizenship.dto.CitizenshipRequest;
import com.fractal.domain.citizenship.dto.CitizenshipResponse;
import com.fractal.domain.profile.candidate.citizenship.CandidateProfileCitizenshipService;
import com.fractal.domain.recruitment.candidate.citizenship.CandidateCitizenshipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profile-management/candidate/citizenship")
@RequiredArgsConstructor
public class CandidateProfileCitizenshipController {

    private final CandidateProfileCitizenshipService citizenshipService;

    @PostMapping()
    public ResponseEntity<CitizenshipResponse> create( @RequestBody @Valid CitizenshipRequest dto) {
        return new ResponseEntity<>(citizenshipService.toDTO(citizenshipService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CitizenshipResponse>> getAll() {
        return ResponseEntity.ok(citizenshipService.getAll().stream().map(citizenshipService::toDTO).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitizenshipResponse> update(@PathVariable Long id, @RequestBody @Valid CitizenshipRequest dto) {
        return ResponseEntity.ok(citizenshipService.toDTO(citizenshipService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        citizenshipService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
