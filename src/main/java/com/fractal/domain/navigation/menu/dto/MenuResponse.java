 package com.fractal.domain.navigation.menu.dto;

 import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
 import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceResponse;
 import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;

 import java.time.LocalDate;
 import java.time.LocalDateTime;
 import java.util.List;

public record MenuResponse(
        Long id,
        String name,
        String url,
        Integer level,
        String icon,
        Long layoutLabelId,
        Integer sequence,
        List<MenuResponse> children,
        LocalDateTime createdDate
) {}
