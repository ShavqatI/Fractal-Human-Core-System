package com.fractal.domain.organization_management.job_description.mapper;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.job_description.JobDescription;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.mapper.QualificationMapperService;
import com.fractal.domain.organization_management.job_description.required_experience.mapper.RequiredExperienceMapperService;
import com.fractal.domain.organization_management.job_description.responsibility.mapper.ResponsibilityMapperService;
import com.fractal.domain.organization_management.position.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class JobDescriptionMapperServiceImpl implements JobDescriptionMapperService {

    private final ResponsibilityMapperService responsibilityMapperService;
    private final QualificationMapperService qualificationMapperService;
    private final RequiredExperienceMapperService requiredExperienceMapperService;
    private final PositionService positionService;
    private final StatusService statusService;
    @Override
    public JobDescriptionResponse toDTO(JobDescription jobDescription) {
        return new JobDescriptionResponse(
                jobDescription.getId(),
                jobDescription.getTitle(),
                jobDescription.getSummary(),
                jobDescription.getEffectiveDate(),
                statusService.toCompactDTO(jobDescription.getStatus()),
                positionService.toCompactDTO(jobDescription.getPosition()),
                Optional.ofNullable(jobDescription.getResponsibilities())
                        .orElse(emptyList())
                        .stream()
                        .map(responsibilityMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(jobDescription.getQualifications())
                        .orElse(emptyList())
                        .stream()
                        .map(qualificationMapperService::toDTO)
                        .collect(Collectors.toList()),
                Optional.ofNullable(jobDescription.getRequiredExperiences())
                        .orElse(emptyList())
                        .stream()
                        .map(requiredExperienceMapperService::toDTO)
                        .collect(Collectors.toList()),
                jobDescription.getCreatedDate()
        );
    }

    @Override
    public JobDescription toEntity(JobDescriptionRequest dto) {
        return mapToEntity( new JobDescription(),dto);
    }

    @Override
    public JobDescription toEntity(JobDescription jobDescription, JobDescriptionRequest dto) {
        return mapToEntity( jobDescription,dto);
    }

    private JobDescription mapToEntity(JobDescription jobDescription, JobDescriptionRequest dto) {
        jobDescription.setTitle(dto.title());
        jobDescription.setSummary(dto.summary());
        jobDescription.setEffectiveDate(dto.effectiveDate());
        jobDescription.setStatus(statusService.getByCode(dto.status()));
        jobDescription.setPosition(positionService.getById(dto.positionId()));
        dto.responsibilities().forEach(responsibilityRequest -> jobDescription.addResponsibility(responsibilityMapperService.toEntity(responsibilityRequest)));
        dto.qualifications().forEach(qualificationRequest-> jobDescription.addQualification(qualificationMapperService.toEntity(qualificationRequest)));
        dto.requiredExperiences().forEach(requiredExperienceRequest -> jobDescription.addRequiredExperience(requiredExperienceMapperService.toEntity(requiredExperienceRequest)));
        return jobDescription;
    }
}
