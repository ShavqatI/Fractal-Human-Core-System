package com.fractal.domain.recruitment.interview.evaluation.section.question.answer;

import com.fractal.domain.education.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationAnswerRepository extends JpaRepository<InterviewEvaluationAnswer,Long> {

    List<InterviewEvaluationAnswer> findAllByQuestionId(Long questionId);

    Optional<InterviewEvaluationAnswer> findByQuestionIdAndId(Long questionId, Long id);
}
