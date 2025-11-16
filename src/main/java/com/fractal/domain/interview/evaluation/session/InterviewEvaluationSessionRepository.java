package com.fractal.domain.interview.evaluation.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSessionRepository extends JpaRepository<InterviewEvaluationSession, Long> {

    Optional<InterviewEvaluationSession> findByInterviewerIdAndId(Long interviewerId, Long id);

    List<InterviewEvaluationSession> findAllByInterviewerId(Long interviewerId);
}
