package com.fractal.domain.recruitment.candidate.work_experience;

import com.fractal.domain.education.dto.EducationRequest;
import com.fractal.domain.education.dto.EducationResponse;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceRequest;
import com.fractal.domain.employment.work_experience.dto.WorkExperienceResponse;

import java.util.List;

public interface CandidateWorkExperienceService {

    CandidateWorkExperience create(Long candidateId, WorkExperienceRequest dto);
    CandidateWorkExperience getById(Long candidateId, Long id);
    List<CandidateWorkExperience> getAllByCandidateId(Long candidateId);
    CandidateWorkExperience update(Long candidateId, Long id, WorkExperienceRequest dto);
    void delete(Long candidateId, Long id);
    WorkExperienceResponse toDTO(CandidateWorkExperience address);
}
