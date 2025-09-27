package com.fractal.domain.interview.evaluation.section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSectionRepository extends JpaRepository<InterviewEvaluationSection,Long> {

    List<InterviewEvaluationSection> findAllByInterviewEvaluationId(Long evaluationId);

    Optional<InterviewEvaluationSection> findByInterviewEvaluationIdAndId(Long evaluationId, Long id);
}
