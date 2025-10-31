package com.fractal.domain.recruitment.candidate.professional_experience.dto;

import com.fractal.domain.dictionary.industry.dto.IndustryResponse;
import com.fractal.domain.dictionary.status.dto.StatusCompactResponse;
import com.fractal.domain.identification_document.type.dto.IdentificationDocumentTypeResponse;
import com.fractal.domain.resource.dto.ResourceResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record CandidateProfessionalExperienceResponse(
        Long id,
        IndustryResponse industry,
        Integer years,
        LocalDateTime createdDate
) { }
