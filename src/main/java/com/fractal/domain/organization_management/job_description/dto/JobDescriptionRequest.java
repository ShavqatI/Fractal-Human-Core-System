package com.fractal.domain.organization_management.job_description.dto;

import com.fractal.domain.organization_management.job_description.accountability.dto.AccountabilityRequest;
import com.fractal.domain.organization_management.job_description.authority.dto.AuthorityRequest;
import com.fractal.domain.organization_management.job_description.kpi.dto.KeyPerformanceIndicatorRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.reporting_line.dto.ReportingLineRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;

import java.time.LocalDate;
import java.util.List;

public record JobDescriptionRequest(
        String title,
        String summary,
        LocalDate effectiveDate,
        Long statusId,
        Long positionId,
        List<ReportingLineRequest> reportingLines,
        List<ResponsibilityRequest> responsibilities,
        List<QualificationRequest> qualifications,
        List<RequiredExperienceRequest> requiredExperiences,
        List<KeyPerformanceIndicatorRequest> keyPerformanceIndicators,
        List<AuthorityRequest> authorities,
        List<AccountabilityRequest> accountabilities
) {}
