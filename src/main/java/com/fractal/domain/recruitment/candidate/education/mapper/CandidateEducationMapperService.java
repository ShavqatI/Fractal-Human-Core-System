package com.fractal.domain.recruitment.candidate.education.mapper;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;
import com.fractal.domain.recruitment.candidate.education.dto.CandidateAddressRequest;
import com.fractal.domain.recruitment.candidate.education.dto.CandidateAddressResponse;

public interface CandidateEducationMapperService {
    EducationResponse toDTO(CandidateEducation education);
    CandidateEducation toEntity(EducationRequest dto);
    CandidateEducation toEntity(CandidateEducation education, EducationRequest dto);
}


