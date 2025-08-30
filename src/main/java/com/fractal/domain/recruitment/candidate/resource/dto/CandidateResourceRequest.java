package com.fractal.domain.recruitment.candidate.resource.dto;

import org.springframework.web.multipart.MultipartFile;

public record CandidateResourceRequest(
        Long candidateResourceTypeId,
        MultipartFile file

) { }
