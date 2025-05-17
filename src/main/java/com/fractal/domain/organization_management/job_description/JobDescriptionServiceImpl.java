package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.dictionary.status.StatusService;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.Qualification;
import com.fractal.domain.organization_management.job_description.qualification.QualificationService;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperience;
import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperienceService;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.job_description.responsibility.ResponsibilityService;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.position.PositionService;
import com.fractal.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final StatusService statusService;


    @Override
    @Transactional
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
    @Transactional
    public JobDescription update(Long id, JobDescriptionRequest dto) {
        try {
            JobDescription jobDescription = findById(id);
            jobDescription.setTitle(dto.title());
            jobDescription.setSummary(dto.summary());
            jobDescription.setEffectiveDate(dto.effectiveDate());
            jobDescription.setStatus(statusService.getByCode(dto.status()));
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
    @Transactional
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
                jobDescription.getStatus().getName(),
                jobDescription.getPosition().getName(),
                jobDescription.getResponsibilities() != null ? jobDescription.getResponsibilities().stream().map(responsibilityService::toDTO).collect(Collectors.toList()) : null,
                jobDescription.getQualifications() != null ? jobDescription.getQualifications().stream().map(qualificationService::toDTO).collect(Collectors.toList()) : null,
                jobDescription.getRequiredExperiences() != null ? jobDescription.getRequiredExperiences().stream().map(requiredExperienceService::toDTO).collect(Collectors.toList()) : null,
                jobDescription.getCreatedDate()
        );
    }

    @Override
    public JobDescription updateResponsibility(Long jobDescriptionId, Long responsibilityId, ResponsibilityRequest dto) {
        JobDescription jobDescription = findById(jobDescriptionId);
        Responsibility responsibility = jobDescription.getResponsibilities().stream()
                .filter(r -> r.getId().equals(responsibilityId))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Responsibility with id: " + responsibilityId + " not found"));
        responsibilityService.update(responsibility.getId(),dto);
        return save(jobDescription);
    }

    @Override
    public JobDescription updateQualification(Long jobDescriptionId, Long qualificationId, QualificationRequest dto) {
        JobDescription jobDescription = findById(jobDescriptionId);
        Qualification qualification = jobDescription.getQualifications().stream()
                .filter(q -> q.getId().equals(qualificationId))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Qualification with id: " + qualificationId + " not found"));
        qualificationService.update(qualification.getId(),dto);
        return save(jobDescription);
    }

    @Override
    public JobDescription updateRequiredExperience(Long jobDescriptionId, Long requiredExperienceId, RequiredExperienceRequest dto) {
        JobDescription jobDescription = findById(jobDescriptionId);
        RequiredExperience requiredExperience = jobDescription.getRequiredExperiences().stream()
                .filter(r -> r.getId().equals(requiredExperienceId))
                .findFirst().orElseThrow(()-> new ResourceNotFoundException("Required Experience with id: " + requiredExperienceId + " not found"));
        requiredExperienceService.update(requiredExperience.getId(),dto);
        return save(jobDescription);
    }

    @Override
    public void removeResponsibility(Long jobDescriptionId, Long responsibilityId) {
        JobDescription jobDescription = findById(jobDescriptionId);
        Responsibility responsibility = responsibilityService.findById(responsibilityId);
        jobDescription.removeResponsibility(responsibility);
        responsibilityService.delete(responsibility);
        save(jobDescription);
    }

    @Override
    public void removeQualification(Long jobDescriptionId, Long qualificationId) {
        JobDescription jobDescription = findById(jobDescriptionId);
        Qualification qualification = qualificationService.findById(qualificationId);
        jobDescription.removeQualification(qualification);
        qualificationService.delete(qualification);
        save(jobDescription);
    }

    @Override
    public void removeRequiredExperience(Long jobDescriptionId, Long experienceId) {
        JobDescription jobDescription = findById(jobDescriptionId);
        RequiredExperience experience = requiredExperienceService.findById(experienceId);
        jobDescription.removeRequiredExperience(experience);
        requiredExperienceService.delete(experience);
        save(jobDescription);
    }

   private JobDescription toEntity(JobDescriptionRequest dto) {
        JobDescription jobDescription = JobDescription.builder()
                .title(dto.title())
                .summary(dto.summary())
                .effectiveDate(dto.effectiveDate())
                .status(statusService.getByCode(dto.status()))
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
