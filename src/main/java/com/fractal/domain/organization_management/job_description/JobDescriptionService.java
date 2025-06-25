package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;

import java.util.List;

public interface JobDescriptionService {
    JobDescription create(JobDescriptionRequest dto);
    List<JobDescription> getAll();
    JobDescription getById(Long id);
    JobDescription update(Long id, JobDescriptionRequest dto);
    void deleteById(Long id);
    JobDescriptionResponse toDTO(JobDescription jobDescription);
    JobDescription save(JobDescription jobDescription);
}
