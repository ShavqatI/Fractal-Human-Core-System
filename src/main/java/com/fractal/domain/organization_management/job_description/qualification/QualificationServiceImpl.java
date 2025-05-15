package com.fractal.domain.organization_management.job_description.qualification;

import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationResponse;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class QualificationServiceImpl implements QualificationService {

      private final QualificationRepository qualificationRepository;
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

    @Override
    public Qualification findById(Long id) {
        return qualificationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Qualification with id: " + id + " not found"));

    }

    @Override
    public void delete(Qualification qualification) {
        qualificationRepository.delete(qualification);
    }
}
