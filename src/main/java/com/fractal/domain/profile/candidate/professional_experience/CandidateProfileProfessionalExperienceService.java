package com.fractal.domain.profile.candidate.professional_experience;

import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperience;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;

import java.util.List;

public interface CandidateProfileProfessionalExperienceService {
    CandidateProfessionalExperience create(CandidateProfessionalExperienceRequest dto);
    List<CandidateProfessionalExperience> getAll();
    CandidateProfessionalExperience getById(Long id);
    CandidateProfessionalExperience update(Long id, CandidateProfessionalExperienceRequest dto);
    void delete(Long id);
    CandidateProfessionalExperienceResponse toDTO(CandidateProfessionalExperience professionalExperience);


}
