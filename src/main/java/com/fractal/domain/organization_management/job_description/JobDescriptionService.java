package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;
import com.fractal.domain.organization_management.job_description.qualification.dto.QualificationRequest;
import com.fractal.domain.organization_management.job_description.required_experience.dto.RequiredExperienceRequest;

import java.util.List;

public interface JobDescriptionService {
    JobDescription create(JobDescriptionRequest dto);
    List<JobDescription> getAll();
    JobDescription getById(Long id);
    JobDescription update(Long id, JobDescriptionRequest dto);
    void deleteById(Long id);
    JobDescriptionResponse toDTO(JobDescription jobDescription);
    JobDescription save(JobDescription jobDescription);

    JobDescription addQualification(Long jobDescriptionId, QualificationRequest dto);
    JobDescription updateQualification(Long jobDescriptionId, Long qualificationId, QualificationRequest dto);
    void deleteQualification(Long jobDescriptionId, Long qualificationId);
    JobDescription updateRequiredExperience(Long jobDescriptionId, Long requiredExperienceId, RequiredExperienceRequest dto);
    JobDescription addRequiredExperience(Long jobDescriptionId, RequiredExperienceRequest dto);
    void deleteRequiredExperience(Long jobDescriptionId, Long experienceId);
}
