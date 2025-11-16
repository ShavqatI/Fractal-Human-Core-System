package com.fractal.domain.organization_management.job_description.mapper;

import com.fractal.domain.organization_management.job_description.JobDescription;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionRequest;
import com.fractal.domain.organization_management.job_description.dto.JobDescriptionResponse;

public interface JobDescriptionMapperService {
    JobDescriptionResponse toDTO(JobDescription jobDescription);

    JobDescription toEntity(JobDescriptionRequest dto);

    JobDescription toEntity(JobDescription jobDescription, JobDescriptionRequest dto);
}


