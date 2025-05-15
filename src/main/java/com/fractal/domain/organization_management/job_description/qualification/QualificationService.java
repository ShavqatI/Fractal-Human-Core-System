package com.fractal.domain.organization_management.job_description.qualification;

import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;

public interface QualificationService {
    QualificationResponse toDTO(Qualification qualification);
    Qualification toEntity(QualificationRequest dto);

    Qualification findById(Long id);
    void delete(Qualification qualification);
}
