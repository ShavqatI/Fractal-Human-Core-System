package com.fractal.domain.interview.template.section.question.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewTemplateAnswerRepository extends JpaRepository<InterviewTemplateAnswer,Long> {

    List<InterviewTemplateAnswer> findAllByInterviewTemplateQuestionId(Long questionId);

    Optional<InterviewTemplateAnswer> findByInterviewTemplateQuestionIdAndId(Long questionId, Long id);
}
