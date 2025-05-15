package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;
import com.fractal.domain.organization_management.job_description.responsibility.dto.ResponsibilityRequest;
import com.fractal.domain.organization_management.position.dto.PositionResponse;

import java.util.List;

public interface JobDescriptionService {
    JobDescription create(JobDescriptionRequest dto);
    List<JobDescription> getAll();
    JobDescription getById(Long id);
    JobDescription update(Long id, JobDescriptionRequest dto);
    void deleteById(Long id);
    JobDescriptionResponse toDTO(JobDescription jobDescription);

    JobDescription updateResponsibility(Long jobDescriptionId, Long responsibilityId, ResponsibilityRequest dto);
    JobDescription updateQualification(Long jobDescriptionId, Long qualificationId, QualificationRequest dto);
    JobDescription updateRequiredExperience(Long jobDescriptionId, Long requiredExperienceId, RequiredExperienceRequest dto);

    void removeResponsibility(Long jobDescriptionId, Long responsibilityId);
    void removeQualification(Long jobDescriptionId, Long qualificationId);
    void removeRequiredExperience(Long jobDescriptionId, Long experienceId);
}
