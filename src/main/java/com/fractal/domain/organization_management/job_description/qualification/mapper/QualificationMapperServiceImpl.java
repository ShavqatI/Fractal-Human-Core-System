package com.fractal.domain.organization_management.job_description.qualification.mapper;

import com.fractal.domain.organization_management.job_description.qualification.Qualification;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class QualificationMapperServiceImpl implements QualificationMapperService {

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
        return mapToEntity(new Qualification(), dto);
    }

    @Override
    public Qualification toEntity(Qualification qualification, QualificationRequest dto) {
        return mapToEntity(qualification, dto);
    }

    private Qualification mapToEntity(Qualification qualification, QualificationRequest dto) {
        qualification.setDescription(dto.description());
        return qualification;
    }
}
