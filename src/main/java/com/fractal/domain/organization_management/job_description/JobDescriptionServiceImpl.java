package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.QualificationService;
import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperienceService;
import com.fractal.domain.organization_management.job_description.responsibility.ResponsibilityService;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class JobDescriptionServiceImpl implements JobDescriptionService {

    private final JobDescriptionRepository jobDescriptionRepository;
    private final PositionService positionService;
    private final RequiredExperienceService requiredExperienceService;
    private final ResponsibilityService responsibilityService;
    private final QualificationService qualificationService;


    @Override
    public JobDescription create(JobDescriptionRequest dto) {
        return save(toEntity(dto));
    }

    @Override
    public List<JobDescription> getAll() {
        return jobDescriptionRepository.findAll();
    }

    @Override
    public JobDescription getById(Long id) {
        return findById(id);
    }

    @Override
    public JobDescription update(Long id, JobDescriptionRequest dto) {
        try {
            JobDescription jobDescription = findById(id);
            jobDescription.setTitle(dto.title());
            jobDescription.setSummary(dto.summary());
            jobDescription.setEffectiveDate(dto.effectiveDate());
            //jobDescription.setStatus();
            jobDescription.setPosition(positionService.getById(dto.positionId()));
            dto.responsibilities().forEach(responsibilityRequest -> jobDescription.addResponsibility(responsibilityService.toEntity(responsibilityRequest)));
            dto.qualifications().forEach(qualificationRequest-> jobDescription.addQualification(qualificationService.toEntity(qualificationRequest)));
            dto.requiredExperiences().forEach(requiredExperienceRequest -> jobDescription.addRequiredExperience(requiredExperienceService.toEntity(requiredExperienceRequest)));
          return save(jobDescription);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        jobDescriptionRepository.delete(findById(id));
    }

    @Override
    public JobDescriptionResponse toDTO(JobDescription jobDescription) {
        return new JobDescriptionResponse(
                jobDescription.getId(),
                jobDescription.getTitle(),
                jobDescription.getSummary(),
                jobDescription.getEffectiveDate(),
                null,//jobDescription.getStatus().getName(),
                jobDescription.getPosition().getName(),
                jobDescription.getResponsibilities() != null ? jobDescription.getResponsibilities().stream().map(responsibilityService::toDTO).collect(Collectors.toList()) : null,
                jobDescription.getQualifications() != null ? jobDescription.getQualifications().stream().map(qualificationService::toDTO).collect(Collectors.toList()) : null,
                jobDescription.getRequiredExperiences() != null ? jobDescription.getRequiredExperiences().stream().map(requiredExperienceService::toDTO).collect(Collectors.toList()) : null,
                jobDescription.getCreatedDate()
        );
    }

   private JobDescription toEntity(JobDescriptionRequest dto) {
        JobDescription jobDescription = JobDescription.builder()
                .title(dto.title())
                .summary(dto.summary())
                .effectiveDate(dto.effectiveDate())
                // add status later
                .position(positionService.getById(dto.positionId()))
                .build();
        dto.responsibilities().forEach(responsibilityRequest -> jobDescription.addResponsibility(responsibilityService.toEntity(responsibilityRequest)));
        dto.qualifications().forEach(qualificationRequest-> jobDescription.addQualification(qualificationService.toEntity(qualificationRequest)));
        dto.requiredExperiences().forEach(requiredExperienceRequest ->jobDescription.addRequiredExperience(requiredExperienceService.toEntity(requiredExperienceRequest)));
       return jobDescription;
    }

    private JobDescription save(JobDescription jobDescription) {
        try {
            return jobDescriptionRepository.save(jobDescription);
        }
        catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private JobDescription findById(Long id) {
        return jobDescriptionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("JobDescription with id: " + id + " not found"));
    }
}
