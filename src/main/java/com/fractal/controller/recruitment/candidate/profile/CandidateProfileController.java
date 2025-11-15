package com.fractal.controller.recruitment.candidate.profile;


import com.fractal.domain.recruitment.candidate.usecase.profile.CandidateProfileService;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileRequest;
import com.fractal.domain.recruitment.candidate.usecase.profile.dto.CandidateProfileResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/profile")
@RequiredArgsConstructor
public class CandidateProfileController {

    private final CandidateProfileService candidateProfileService;

    @PostMapping
    public ResponseEntity<CandidateProfileResponse> create(@RequestBody @Valid CandidateProfileRequest dto) {
        return new ResponseEntity<>(candidateProfileService.toDTO(candidateProfileService.create(dto)), HttpStatus.CREATED);
    }
}
