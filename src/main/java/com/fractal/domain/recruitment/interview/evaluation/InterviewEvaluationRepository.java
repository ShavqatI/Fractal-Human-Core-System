package com.fractal.domain.recruitment.interview.evaluation;

import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InterviewEvaluationRepository extends JpaRepository<InterviewEvaluation,Long> {

}
