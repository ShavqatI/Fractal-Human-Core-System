package com.fractal.domain.recruitment.interview.evaluation.session.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSessionAnswerSubmissionRepository extends JpaRepository<InterviewEvaluationSessionAnswerSubmission,Long> {

    Optional<InterviewEvaluationSessionAnswerSubmission> findByInterviewEvaluationSessionIdAndId(Long evaluationSessionId, Long id);

    List<InterviewEvaluationSessionAnswerSubmission> findAllByInterviewEvaluationSessionId(Long evaluationSessionId);
}
