package com.fractal.domain.recruitment.candidate.professional_experience;

import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;

import java.util.List;

public interface CandidateProfessionalExperienceService {

    CandidateProfessionalExperience create(Long candidateId, CandidateProfessionalExperienceRequest dto);
    List<CandidateProfessionalExperience> getAllByCandidateId(Long candidateId);
    CandidateProfessionalExperience getById(Long candidateId , Long id);
    CandidateProfessionalExperienceResponse toDTO(CandidateProfessionalExperience professionalExperience);
    CandidateProfessionalExperience update(Long candidateId, Long id, CandidateProfessionalExperienceRequest dto);
    void delete(Long candidateId,Long id);
}
