package com.fractal.domain.organization_management.job_description.qualification;

import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
import org.springframework.stereotype.Service;

@Service
class QualificationServiceImpl implements QualificationService {
    @Override
    public QualificationResponse toDTO(Qualification qualification) {
        return new QualificationResponse(
                qualification.getId(),
                qualification.getDescription(),
                qualification.getCreatedDate()
        );
    }

    @Override
    public Qualification toEntity(QualificationRequest dto) {
        return Qualification.builder().description(dto.description()).build();
    }
}
