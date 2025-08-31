package com.fractal.domain.recruitment.interview.evaluation.section;

import com.fractal.domain.recruitment.interview.evaluation.section.question.InterviewEvaluationQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSectionRepository extends JpaRepository<InterviewEvaluationSection,Long> {

    List<InterviewEvaluationSection> findAllByEvaluationId(Long evaluationId);

    Optional<InterviewEvaluationSection> findByEvaluationIdAndId(Long evaluationId, Long id);
}
