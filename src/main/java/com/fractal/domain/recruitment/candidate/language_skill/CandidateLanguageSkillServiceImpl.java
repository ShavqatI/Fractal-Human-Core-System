package com.fractal.domain.recruitment.candidate.language_skill;

import com.fractal.domain.education.language_skill.dto.LanguageSkillRequest;
import com.fractal.domain.education.language_skill.dto.LanguageSkillResponse;
import com.fractal.domain.recruitment.candidate.CandidateService;
import com.fractal.domain.recruitment.candidate.language_skill.mapper.CandidateLanguageSkillMapperService;
import com.fractal.exception.ResourceWithIdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
class CandidateLanguageSkillServiceImpl implements CandidateLanguageSkillService {

    private final CandidateLanguageSkillRepository languageSkillRepository;
    private final CandidateLanguageSkillMapperService mapperService;
    private final CandidateService candidateService;

    @Override
    @Transactional
    public CandidateLanguageSkill create(Long candidateId, LanguageSkillRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var languageSkill = mapperService.toEntity(dto);
        candidate.addLanguageSkill(languageSkill);
        candidateService.save(candidate);
        return languageSkill;
    }

    @Override
    public List<CandidateLanguageSkill> getAllByCandidateId(Long candidateId) {
        return languageSkillRepository.findAllByCandidateId(candidateId);
    }

    @Override
    public CandidateLanguageSkill getById(Long candidateId, Long id) {
        return languageSkillRepository.findByCandidateIdAndId(candidateId, id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }

    @Override
    @Transactional
    public CandidateLanguageSkill update(Long candidateId, Long id, LanguageSkillRequest dto) {
        var candidate = candidateService.getById(candidateId);
        var languageSkill = candidate.getLanguageSkills()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        languageSkill = mapperService.toEntity(languageSkill, dto);
        languageSkillRepository.save(languageSkill);
        candidateService.save(candidate);
        return languageSkill;
    }

    @Override
    @Transactional
    public void delete(Long candidateId, Long id) {
        var candidate = candidateService.getById(candidateId);
        var languageSkill = candidate.getLanguageSkills()
                .stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
        candidate.removeLanguageSkill(languageSkill);
        candidateService.save(candidate);
    }

    @Override
    public LanguageSkillResponse toDTO(CandidateLanguageSkill candidateLanguageSkill) {
        return mapperService.toDTO(candidateLanguageSkill);
    }


    @Override
    public CandidateLanguageSkill getById(Long id) {
        return findById(id);
    }

    @Override
    public CandidateLanguageSkill save(CandidateLanguageSkill candidateLanguageSkill) {
        try {
            return languageSkillRepository.save(candidateLanguageSkill);
        } catch (DataAccessException e) {
            throw new RuntimeException(e.getMostSpecificCause().getMessage());
        }
    }

    private CandidateLanguageSkill findById(Long id) {
        return languageSkillRepository.findById(id).orElseThrow(() -> new ResourceWithIdNotFoundException(this, id));
    }
}
