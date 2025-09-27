package com.fractal.domain.interview.evaluation.session.answer.selected;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSessionSelectedAnswerRepository extends JpaRepository<InterviewEvaluationSessionSelectedAnswer,Long> {

    Optional<InterviewEvaluationSessionSelectedAnswer> findByInterviewEvaluationSessionAnswerSubmissionIdAndId(Long answerSubmissionId, Long id);

    List<InterviewEvaluationSessionSelectedAnswer> findAllByInterviewEvaluationSessionAnswerSubmissionId(Long answerSubmissionId);
}
