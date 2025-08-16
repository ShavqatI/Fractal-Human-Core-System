package com.fractal.domain.recruitment.candidate.work_experience.mapper;

import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.recruitment.candidate.work_experience.CandidateWorkExperience;

public interface CandidateWorkExperienceMapperService {
    WorkExperienceResponse toDTO(CandidateWorkExperience workExperience);
    CandidateWorkExperience toEntity(WorkExperienceRequest dto);
    CandidateWorkExperience toEntity(CandidateWorkExperience workExperience, WorkExperienceRequest dto);
}


