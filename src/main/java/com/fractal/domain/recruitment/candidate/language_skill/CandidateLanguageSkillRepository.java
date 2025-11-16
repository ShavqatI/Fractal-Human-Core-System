package com.fractal.domain.recruitment.candidate.language_skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CandidateLanguageSkillRepository extends JpaRepository<CandidateLanguageSkill, Long> {

    List<CandidateLanguageSkill> findAllByCandidateId(Long candidateId);

    Optional<CandidateLanguageSkill> findByCandidateIdAndId(Long candidateId, Long id);
}
