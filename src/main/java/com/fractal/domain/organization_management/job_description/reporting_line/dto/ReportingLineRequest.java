package com.fractal.domain.organization_management.job_description.reporting_line.dto;

import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;

import java.time.LocalDate;
import java.util.List;

public record ReportingLineRequest(
        Long positionId,
        Long reportingTypeId,
        Long statusId

) {}
