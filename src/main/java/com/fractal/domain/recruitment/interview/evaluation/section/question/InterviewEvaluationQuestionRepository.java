package com.fractal.domain.recruitment.interview.evaluation.section.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationQuestionRepository extends JpaRepository<InterviewEvaluationQuestion,Long> {

    List<InterviewEvaluationQuestion> findAllBySectionId(Long sectionId);

    Optional<InterviewEvaluationQuestion> findBySectionIdAndId(Long employeeId, Long id);
}
