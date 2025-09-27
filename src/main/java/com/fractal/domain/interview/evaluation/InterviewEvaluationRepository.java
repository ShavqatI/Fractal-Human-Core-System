package com.fractal.domain.interview.evaluation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface InterviewEvaluationRepository extends JpaRepository<InterviewEvaluation,Long> {

}
