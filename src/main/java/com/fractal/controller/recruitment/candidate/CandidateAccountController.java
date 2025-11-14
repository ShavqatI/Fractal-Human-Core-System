package com.fractal.controller.recruitment.candidate;


import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.dto.CandidateCompactResponse;
import com.fractal.domain.recruitment.candidate.dto.CandidateRequest;
import com.fractal.domain.recruitment.candidate.dto.CandidateResponse;
import com.fractal.domain.recruitment.candidate.usecase.account.CandidateAccountService;
import com.fractal.domain.recruitment.candidate.usecase.account.dto.CandidateAccountRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recruitment/candidate/account")
@RequiredArgsConstructor
public class CandidateAccountController {

    private final CandidateAccountService candidateAccountService;
    private final CandidateService candidateService;
    @PostMapping
    public ResponseEntity<CandidateResponse> create(@RequestBody @Valid CandidateAccountRequest dto) {
        return new ResponseEntity<>(candidateService.toDTO(candidateAccountService.create(dto)), HttpStatus.CREATED);
    }
}
