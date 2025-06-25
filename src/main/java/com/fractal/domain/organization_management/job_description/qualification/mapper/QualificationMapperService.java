package com.fractal.domain.organization_management.job_description.qualification.mapper;

import com.fractal.domain.organization_management.job_description.qualification.Qualification;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;

public interface QualificationMapperService {
    QualificationResponse toDTO(Qualification qualification);
    Qualification toEntity(QualificationRequest dto);
    Qualification toEntity(Qualification qualification, QualificationRequest dto);
}


