package com.fractal.domain.profile.candidate.language_skill;

import com.fractal.domain.authorization.AuthenticatedService;
import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkill;
import com.fractal.domain.employee_management.language_skill.EmployeeLanguageSkillService;
import com.fractal.domain.recruitment.candidate.identification_document.CandidateIdentificationDocument;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkill;
import com.fractal.domain.recruitment.candidate.language_skill.CandidateLanguageSkillService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateProfileLanguageSkillServiceImpl implements CandidateProfileLanguageSkillService {

   private final CandidateLanguageSkillService languageSkillService;
   private final AuthenticatedService authenticatedService;


    @Override
    public CandidateLanguageSkill create(LanguageSkillRequest dto) {
        return languageSkillService.create(authenticatedService.getCandidateId(), dto);
    }

    @Override
    public List<CandidateLanguageSkill> getAll() {
        return languageSkillService.getAllByCandidateId(authenticatedService.getCandidateId());
    }

    @Override
    public CandidateLanguageSkill getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateLanguageSkill update(Long id, LanguageSkillRequest dto) {
        return languageSkillService.update(authenticatedService.getCandidateId(),findById(id).getId(),dto);
    }

    @Override
    public void delete(Long id) {
        languageSkillService.delete(authenticatedService.getCandidateId(),findById(id).getId());
    }

    @Override
    public LanguageSkillResponse toDTO(CandidateLanguageSkill candidateLanguageSkill) {
        return languageSkillService.toDTO(candidateLanguageSkill);
    }

    private CandidateLanguageSkill findById(Long id) {
        return languageSkillService.getAllByCandidateId(authenticatedService.getCandidateId()).stream()
                .filter(languageSkill -> languageSkill.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ResourceWithIdNotFoundException(this,id));
    }
}
