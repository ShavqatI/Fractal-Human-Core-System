package com.fractal.domain.recruitment.candidate.professional_experience.mapper;

import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;
import com.fractal.domain.recruitment.candidate.professional_experience.CandidateProfessionalExperience;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceResponse;

public interface CandidateProfessionalExperienceMapperService {
    CandidateProfessionalExperienceResponse toDTO(CandidateProfessionalExperience professionalExperience);
    CandidateProfessionalExperience toEntity(CandidateProfessionalExperienceRequest dto);
    CandidateProfessionalExperience toEntity(CandidateProfessionalExperience professionalExperience, CandidateProfessionalExperienceRequest dto);
}


