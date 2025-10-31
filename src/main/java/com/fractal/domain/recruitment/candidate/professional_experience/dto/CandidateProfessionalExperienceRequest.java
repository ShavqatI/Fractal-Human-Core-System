package com.fractal.domain.recruitment.candidate.professional_experience.dto;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public record CandidateProfessionalExperienceRequest(
        Long industryId,
        Integer years
) {
}
