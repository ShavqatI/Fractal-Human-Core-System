package com.fractal.domain.recruitment.candidate.professional_experience.dto;

import com.fractal.domain.dictionary.industry.dto.IndustryResponse;

import java.time.LocalDateTime;

public record CandidateProfessionalExperienceResponse(
        Long id,
        IndustryResponse industry,
        Integer years,
        LocalDateTime createdDate
) {
}
