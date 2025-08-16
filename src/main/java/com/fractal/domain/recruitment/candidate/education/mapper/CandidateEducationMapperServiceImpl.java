package com.fractal.domain.recruitment.candidate.education.mapper;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.education.mapper.EducationMapperService;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CandidateEducationMapperServiceImpl implements CandidateEducationMapperService {

    private final EducationMapperService educationMapperService;
    @Override
    public EducationResponse toDTO(CandidateEducation education) {
        return educationMapperService.toDTO(education);
    }

    @Override
    public CandidateEducation toEntity(EducationRequest dto) {
        return (CandidateEducation) educationMapperService.toEntity(dto);
    }

    @Override
    public CandidateEducation toEntity(CandidateEducation education, EducationRequest dto) {
        return (CandidateEducation) educationMapperService.toEntity(education,dto);
    }

}
