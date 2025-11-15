package com.fractal.controller.recruitment.candidate.profile;


import com.fractal.domain.recruitment.candidate.usecase.account.CandidateAccountService;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountRequest;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/profile")
@RequiredArgsConstructor
public class CandidateProfileController {

    private final CandidateAccountService candidateAccountService;

    @PostMapping
    public ResponseEntity<CandidateAccountResponse> create(@RequestBody @Valid CandidateAccountRequest dto) {
        return new ResponseEntity<>(candidateAccountService.toDTO(candidateAccountService.create(dto)), HttpStatus.CREATED);
    }


}
