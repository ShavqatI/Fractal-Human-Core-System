package com.fractal.domain.profile.candidate.education;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.recruitment.candidate.education.CandidateEducation;

import java.util.List;

public interface CandidateProfileEducationService {
    CandidateEducation create(EducationRequest dto);

    CandidateEducation getById(Long id);

    List<CandidateEducation> getAll();

    CandidateEducation update(Long id, EducationRequest dto);

    void delete(Long id);

    EducationResponse toDTO(CandidateEducation education);


}
