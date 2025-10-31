package com.fractal.domain.recruitment.candidate.professional_experience;

import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.recruitment.candidate.professional_experience.dto.CandidateProfessionalExperienceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateProfessionalExperienceServiceImpl implements CandidateProfessionalExperienceService {

    @Override
    public CandidateProfessionalExperience create(Long candidateId, CandidateProfessionalExperienceRequest dto) {
        return null;
    }

    @Override
    public List<CandidateProfessionalExperience> getAllByCandidateId(Long candidateId) {
        return null;
    }

    @Override
    public CandidateProfessionalExperience getById(Long candidateId, Long id) {
        return null;
    }

    @Override
    public CandidateProfessionalExperience getById(Long id) {
        return null;
    }

    @Override
    public LanguageSkillResponse toDTO(CandidateProfessionalExperience professionalExperience) {
        return null;
    }

    @Override
    public CandidateProfessionalExperience update(Long candidateId, Long id, CandidateProfessionalExperienceRequest dto) {
        return null;
    }

    @Override
    public void delete(Long candidateId, Long id) {

    }
}
