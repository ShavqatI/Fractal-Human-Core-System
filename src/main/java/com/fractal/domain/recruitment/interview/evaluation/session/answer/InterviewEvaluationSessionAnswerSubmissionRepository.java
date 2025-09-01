package com.fractal.domain.recruitment.interview.evaluation.session.answer;

import com.fractal.domain.recruitment.interview.evaluation.session.InterviewEvaluationSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSessionAnswerSubmissionRepository extends JpaRepository<InterviewEvaluationSession,Long> {

    Optional<InterviewEvaluationSession> findByInterviewEvaluationIdAndId(Long evaluationId, Long id);

    List<InterviewEvaluationSession> findAllByInterviewEvaluationId(Long evaluationId);
}
