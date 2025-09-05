package com.fractal.domain.recruitment.interview.evaluation.session;

import com.fractal.domain.recruitment.interview.evaluation.session.answer.selected.InterviewEvaluationSessionSelectedAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSessionRepository extends JpaRepository<InterviewEvaluationSession,Long> {

    Optional<InterviewEvaluationSession> findByInterviewIdAndId(Long interviewId, Long id);

    List<InterviewEvaluationSession> findAllByInterviewId(Long interviewId);
}
