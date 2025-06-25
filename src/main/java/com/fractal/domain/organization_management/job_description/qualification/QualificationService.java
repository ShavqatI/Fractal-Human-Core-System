package com.fractal.domain.organization_management.job_description.qualification;

import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;

import java.util.List;

public interface QualificationService {

    Qualification create(Long jobDescriptionId, QualificationRequest dto);
    List<Qualification> getAllByJobDescriptionId(Long jobDescriptionId);
    Qualification getById(Long jobDescriptionId ,Long id);
    Qualification update(Long jobDescriptionId,Long id, QualificationRequest dto);
    void delete(Long jobDescriptionId, Long id);
    QualificationResponse toDTO(Qualification qualification);
}
