package com.fractal.domain.recruitment.candidate.work_experience.mapper;

import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;
import com.fractal.domain.employment.work_experience.mapper.WorkExperienceMapperService;
import com.fractal.domain.recruitment.candidate.work_experience.CandidateWorkExperience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateWorkExperienceMapperServiceImpl implements CandidateWorkExperienceMapperService {

    private final WorkExperienceMapperService mapperService;
    @Override
    public WorkExperienceResponse toDTO(CandidateWorkExperience workExperience) {
        return mapperService.toDTO(workExperience);
    }

    @Override
    public CandidateWorkExperience toEntity(WorkExperienceRequest dto) {
        return (CandidateWorkExperience) mapperService.toEntity(dto);
    }

    @Override
    public CandidateWorkExperience toEntity(CandidateWorkExperience workExperience, WorkExperienceRequest dto) {
        return (CandidateWorkExperience) mapperService.toEntity(workExperience,dto);
    }

}
