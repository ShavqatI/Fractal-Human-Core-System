package com.fractal.domain.recruitment.candidate.resource.type.dto;

import java.time.LocalDateTime;

public record CandidateResourceTypeResponse(
        Long id,
        String code,
        String name,
        LocalDateTime createdDate

) {

}
