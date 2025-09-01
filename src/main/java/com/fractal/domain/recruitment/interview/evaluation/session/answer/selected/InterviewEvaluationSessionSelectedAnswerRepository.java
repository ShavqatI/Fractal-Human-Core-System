package com.fractal.domain.recruitment.interview.evaluation.session.answer.selected;

import com.fractal.domain.recruitment.interview.evaluation.section.InterviewEvaluationSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface InterviewEvaluationSessionSelectedAnswerRepository extends JpaRepository<InterviewEvaluationSessionSelectedAnswer,Long> {

    Optional<InterviewEvaluationSessionSelectedAnswer> findByInterviewEvaluationSessionAnswerSubmissionIdAndId(Long submissionId, Long id);

    List<InterviewEvaluationSessionSelectedAnswer> findAllByInterviewEvaluationSessionAnswerSubmissionId(Long submissionId);
}
