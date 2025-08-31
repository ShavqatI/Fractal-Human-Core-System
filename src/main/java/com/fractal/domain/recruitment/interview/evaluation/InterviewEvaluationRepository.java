package com.fractal.domain.recruitment.interview.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InterviewEvaluationRepository extends JpaRepository<InterviewEvaluation,Long> {

}
