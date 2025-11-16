package com.fractal.domain.employee_management.professional_experience.dto;

import com.fractal.domain.dictionary.industry.dto.IndustryResponse;

import java.time.LocalDateTime;

public record EmployeeProfessionalExperienceResponse(
        Long id,
        IndustryResponse industry,
        Integer years,
        LocalDateTime createdDate
) { }
