package com.fractal.controller.profile.candidate;


import com.fractal.domain.profile.candidate.CandidateProfileService;
import com.fractal.domain.profile.candidate.dto.CandidateProfileRequest;
import com.fractal.domain.profile.candidate.dto.CandidateProfileResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/profile-management/candidate")
@RequiredArgsConstructor
public class CandidateProfileController {

    private final CandidateProfileService candidateProfileService;

    @PostMapping()
    public ResponseEntity<CandidateProfileResponse> create(@RequestBody @Valid CandidateProfileRequest dto) {
        return new ResponseEntity<>(candidateProfileService.toProfileDTO(candidateProfileService.create(dto)), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<CandidateResponse> get() {
        return ResponseEntity.ok(candidateProfileService.toDTO(candidateProfileService.getById()));
    }

    @PutMapping()
    public ResponseEntity<CandidateProfileResponse> update(@RequestBody @Valid CandidateProfileRequest dto) {
        return ResponseEntity.ok(candidateProfileService.toProfileDTO(candidateProfileService.update(dto)));
    }


}
