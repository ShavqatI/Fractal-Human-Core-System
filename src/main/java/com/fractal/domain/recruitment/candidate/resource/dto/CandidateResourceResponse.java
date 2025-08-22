package com.fractal.domain.recruitment.candidate.resource.dto;

import com.fractal.domain.recruitment.candidate.resource.type.dto.CandidateResourceTypeResponse;

import java.time.LocalDateTime;

public record CandidateResourceResponse(
        Long id,
        CandidateResourceTypeResponse candidateResourceType,
        String url,
        String fileName,
        String contentType,
        Long sizeInBytes,
        LocalDateTime createdDate
) {
}
