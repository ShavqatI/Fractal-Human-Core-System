package com.fractal.domain.interview.evaluation.section.question.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationAnswerRepository extends JpaRepository<InterviewEvaluationAnswer,Long> {

    List<InterviewEvaluationAnswer> findAllByInterviewEvaluationQuestionId(Long questionId);

    Optional<InterviewEvaluationAnswer> findByInterviewEvaluationQuestionIdAndId(Long questionId, Long id);
}
